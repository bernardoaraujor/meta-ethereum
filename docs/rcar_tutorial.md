# Running geth on an RCar H3 Starter Kit

This tutorial is meant to act as a proof of concept for meta-ethereum. Because I want to show the possibility of running the Ethereum blockchain on Automotive applications, we are going to focus on an [RCar H3 Starter Kit](https://elinux.org/R-Car/Boards/H3SK).

You can find a video with a screencast of this tutorial on [YouTube](https://www.youtube.com/watch?v=X7G0kdYsrg8).

So, let's start.

Prepare your host for yocto development. Refer to [Yocto's official documentation](https://www.yoctoproject.org/docs/latest/mega-manual/mega-manual.html#detailed-supported-distros) for more details on setting up.

Assuming you are using Ubuntu (16.04 or 18.04):
```
$ sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath socat cpio python python3 python3-pip python3-pexpect xz-utils debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa libsdl1.2-dev xterm
```
Clone poky:

```
$ mkdir yocto
$ cd yocto
$ git clone git://git.yoctoproject.org/poky
$ cd poky; git checkout 7e7ee662f5dea4d090293045f7498093322802cc
```

Clone the other OE layers and point them to the respective commits:
```
$ cd ..; git clone https://github.com/openembedded/meta-openembedded
$ cd meta-openembedded; git checkout 352531015014d1957d6444d114f4451e241c4d23
$ cd ..; git clone git://git.linaro.org/openembedded/meta-linaro.git
$ cd meta-linaro; git checkout 75dfb67bbb14a70cd47afda9726e2e1c76731885
$ cd ..; git clone git://github.com/renesas-rcar/meta-renesas
$ cd meta-renesas; git checkout 20fcc94a8d05eda80250f27e87aaa3cfc3275300
$ git clone http://github.com/bernardoaraujor/meta-ethereum # just point to master's head
```

Start the build environment and copy Renesas' local build configs:
```
$ source poky/oe-init-build-env
$ cp ../meta-renesas/meta-rcar-gen3/docs/sample/conf/h3ulcb/poky-gcc/bsp/bblayers.conf conf/bblayers.conf
$ cp ../meta-renesas/meta-rcar-gen3/docs/sample/conf/h3ulcb/poky-gcc/bsp/local.conf conf/local.conf 
```

Inform BitBake about `meta-ethereum` by adding them to `conf/bblayers.conf`:
```
...

BBLAYERS ?= " \
  ${TOPDIR}/../poky/meta \
  ${TOPDIR}/../poky/meta-poky \
  ${TOPDIR}/../poky/meta-yocto-bsp \
  ${TOPDIR}/../meta-renesas/meta-rcar-gen3 \
  ${TOPDIR}/../meta-openembedded/meta-oe \
  ${TOPDIR}/../meta-linaro/meta-optee \
  ${TOPDIR}/../meta-ethereum \
  "
```

Inform BitBake that we want geth and openssh to be included in the image build. We do this by adding the following variables to the end of `conf/local.conf`
```
...
IMAGE_INSTALL_append = " geth openssh"
```

Build a core-image-minimal image:
```
$ bitbake core-image-minimal
```

## Loading kernel via TFTP and rootfs via NFS

Setup a TFTP server on your host by installing tftpd-hpa package along with tftp tools:

```
$ sudo apt-get install tftp
```

Copy `Image` and `Image-r8a7795-h3ulcb.dtb` to TFTP server root.

```
 $ cd tmp/deploy/images/h3ulcb
 $ cp Image /srv/tftp/
 $ cp Image-r8a7795-h3ulcb.dtb /srv/tftp/
```

Verify that TFTP server is working.
```
$ tftp
tftp> get localhost:Image
```
Setup NFS server by Installing necessary packages:

```
$ sudo apt-get install nfs-kernel-server nfs-common
```

Start NFS server:
```
$ sudo systemctl start nfs-kernel-server
```

Export rootFS to NFS by unpacking the rootfs to a dedicated directory:

```
$ IMAGE=core
$ MACHINE=h3ulcb
$ NFS_ROOT=/srv/nfs/${MACHINE}
$ sudo mkdir -p "${NFS_ROOT}"
$ sudo rm -rf "${NFS_ROOT}"/*
$ sudo tar -xjf "${WORK}/build/tmp/deploy/images/${MACHINE}/core-image-${IMAGE}-${MACHINE}-*.tar.bz2" -C "${NFS_ROOT}"
$  sync
```

Edit /etc/exports:
```
$ sudo vi /etc/exports
```
add:

```
/srv/nfs/h3ulcb	*(rw,no_subtree_check,sync,no_root_squash,no_all_squash)
```
Save the file and exit. Force NFS server to re-read /etc/exports

```
$ sudo exportfs -a
```

Verify that NFS is working.
```
$ showmount -e localhost
Export list for localhost:
/srv/nfs/h3ulcb *
```

Connect to serial console over microUSB using minicom or picocom. Switch the board on or reset it. Press any key to stop U-Boot automatic countdown.

```
[    0.000193] NOTICE:  BL2: R-Car Gen3 Initial Program Loader(CA57) Rev.1.0.14
[    0.005760] NOTICE:  BL2: PRR is R-Car H3 Ver2.0
[    0.010334] NOTICE:  BL2: Board is unknown Rev0.0
[    0.015005] NOTICE:  BL2: Boot device is HyperFlash(80MHz)
[    0.020444] NOTICE:  BL2: LCM state is CM
[    0.024419] NOTICE:  BL2: AVS setting succeeded. DVFS_SetVID=0x52
[    0.030610] NOTICE:  BL2: DDR3200(rev.0.22)NOTICE:  [COLD_BOOT]NOTICE:  ..0
[    0.091223] NOTICE:  BL2: DRAM Split is 4ch
[    0.095109] NOTICE:  BL2: QoS is default setting(rev.0.14)
[    0.100608] NOTICE:  BL2: Lossy Decomp areas
[    0.104785] NOTICE:       Entry 0: DCMPAREACRAx:0x80000540 DCMPAREACRBx:0x570
[    0.111870] NOTICE:       Entry 1: DCMPAREACRAx:0x40000000 DCMPAREACRBx:0x0
[    0.118782] NOTICE:       Entry 2: DCMPAREACRAx:0x20000000 DCMPAREACRBx:0x0
[    0.125697] NOTICE:  BL2: v1.3(release):4eef9a2
[    0.130187] NOTICE:  BL2: Built : 15:20:40, Mar  7 2018
[    0.135374] NOTICE:  BL2: Normal boot
[    0.139015] NOTICE:  BL2: dst=0xe6320190 src=0x8180000 len=512(0x200)
[    0.145561] NOTICE:  BL2: dst=0x43f00000 src=0x8180400 len=6144(0x1800)
[    0.152024] NOTICE:  BL2: dst=0x44000000 src=0x81c0000 len=65536(0x10000)
[    0.159249] NOTICE:  BL2: dst=0x44100000 src=0x8200000 len=524288(0x80000)
[    0.169729] NOTICE:  BL2: dst=0x50000000 src=0x8640000 len=1048576(0x100000)


U-Boot 2015.04 (Mar 07 2018 - 16:20:45)

CPU: Renesas Electronics R8A7795 rev 2.0
Board: H3ULCB
I2C:   ready
DRAM:  3.9 GiB
MMC:   sh-sdhi: 0, sh-sdhi: 1
In:    serial
Out:   serial
Err:   serial
Net:   ravb
Hit any key to stop autoboot:  0 

```

Configure Ethernet, TFTP, and kernel command line args in U-Boot.
Here, the board's IP address is set to `192.168.1.38` and the host's IP is `192.168.1.37`:
```
=> setenv ipaddr 192.168.1.38
=> setenv serverip 192.168.1.37
=> setenv bootcmd 'tftp 0x48080000 Image; tftp 0x48000000 Image-r8a7795-h3ulcb.dtb; booti 0x48080000 - 0x48000000'
=> setenv bootargs 'ignore_loglevel rw root=/dev/nfs nfsroot=192.168.1.37:/srv/nfs/h3ulcb,nfsvers=3 ip=192.168.1.38:192.168.1.37::255.255.255.0:h3ulcb'
=> saveenv
```

Verify the connection over Ethernet from U-Boot:
```
=> ping 192.168.1.37
ravb:0 is connected to ravb.  Reconnecting to ravb
ravb Waiting for PHY auto negotiation to complete.. done
ravb: 100Base/Full
Using ravb device
host 192.168.1.37 is alive
```

Tell UBoot to boot the kernel:
```
=> run bootcmd
```

## Connecting the RCar to a geth node

Open another terminal and install the go-ethereum package to your development host:
```
$ sudo apt-get install software-properties-common
$ sudo add-apt-repository -y ppa:ethereum/ethereum
$ sudo apt-get update
$ sudo apt-get install ethereum
```

Create a dummy wallet:

```
$ geth account new
Your new account is locked with a password. Please give a password. Do not forget this password.
Passphrase: 
Repeat passphrase: 
Address: {f1c0fc4fd943c8664436bf7f3fc75800754b60fd}
```

Start a light node on the host, with support for WebSockets by using the --ws and --wsaddr flags. Also, `wsorigins` is used so our node accepts websockets requests from the QEMU machine:
```
$ geth --syncmode "light" --ws --wsaddr "192.168.1.37" --wsorigins "http://h3ulcb"

```

Connect to the RCar via ssh and connect a geth client to the running node:
```
$ ssh root@192.168.1.38
The authenticity of host '192.168.1.38 (192.168.1.38)' can't be established.
ECDSA key fingerprint is SHA256:gof8NFagRJKxRcauiSBmUABhFun2bdqjvQMLXYZhN7g.
Are you sure you want to continue connecting (yes/no)? yes
Warning: Permanently added '192.168.1.38' (ECDSA) to the list of known hosts.
Last login: Sat Jun 22 20:38:20 2019
root@h3ulcb:~#
root@h3ulcb:~#
root@h3ulcb:~# geth attach ws://192.168.1.37:8546
Welcome to the Geth JavaScript console!

instance: Geth/v1.8.27-stable-4bcc0a37/linux-amd64/go1.10.4
 modules: eth:1.0 net:1.0 rpc:1.0 web3:1.0

> 

```

Finally, print some information on geth's console from the RCar's geth client:
```
> net.listening
true
> net.peerCount
1
#wait some minutes, then look at the peer count again
> net.peerCount
3
> eth.accounts
["0xf1c0fc4fd943c8664436bf7f3fc75800754b60fd"]
#same wallet address that we created on the host
> eth.getBalance(eth.accounts[0])
0
> eth.blockNumber
7985956
#wait some minutes, then try to see the blockNumber again
> eth.blockNumber
7985960
> eth.gasPrice
4000000000
```

That's it! You have connected your RCar H3 to the Ethereum Blockchain! Of course, real smart contracts and relevant interactions would take a lot more work. This tutorial is only meant to act as a proof of concept of meta-ethereum.

---

Copyright (C) 2019 Bernardo Rodrigues <bernardoaraujor@gmail.com>

Released under [GPLv3](https://github.com/bernardoaraujor/meta-ethereum/blob/master/LICENSE).


