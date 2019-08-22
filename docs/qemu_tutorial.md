# Running geth on a QEMUlated machine

This tutorial is meant to act as a proof of concept for meta-ethereum. Because I want to show the possibility of running the Ethereum blockchain on exotic architectures, we are going to focus on an emulated version of a MIPS 32 bits machine.

You can find a video with a screencast of this tutorial on [YouTube](https://youtu.be/IZ6nDKGy7NA).

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
$ git clone git://git.yoctoproject.org/poky -b sumo
```

Clone the other OE layers:
```
$ git clone https://github.com/openembedded/meta-openembedded -b sumo
$ git clone http://github.com/bernardoaraujor/meta-ethereum
```

Start the build environment:
```
$ source oe-init-build-env
```

Inform BitBake about your layers by adding them to `conf/bblayers.conf`:
```
...

BBLAYERS ?= " \
  /home/bernardo/dev/yocto/poky/meta \
  /home/bernardo/dev/yocto/poky/meta-poky \
  /home/bernardo/dev/yocto/poky/meta-yocto-bsp \
  /home/bernardo/dev/yocto/meta-openembedded/meta-oe \
  /home/bernardo/dev/yocto/meta-ethereum \
  "
```

Inform BitBake that we want to build images for a QEMU MIPS 32 machine and that we want geth to be included in the image build. We do this by adding the following variables to the end of `conf/local.conf`
```
...
MACHINE = "qemumips"

IMAGE_INSTALL_append = " geth openssh"
```

Build a core-image-minimal image:
```
$ bitbake core-image-minimal
```

Building an image will probably take a long time. After BitBake has finished, run qemu:

```
$ runqemu qemumips core-image-minimal nographic
```

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

Run ifconfig. Here, `192.168.7.1` is the IP address of the tap0 interface created on my host by QEMU. 
```
$ ifconfig
enp4s0    Link encap:Ethernet  HWaddr 74:d0:2b:be:c4:f3  
          inet addr:192.168.1.37  Bcast:192.168.1.255  Mask:255.255.255.0
          inet6 addr: fe80::858d:213e:73ec:3395/64 Scope:Link
          UP BROADCAST RUNNING MULTICAST  MTU:1500  Metric:1
          RX packets:469 errors:0 dropped:0 overruns:0 frame:0
          TX packets:330 errors:0 dropped:0 overruns:0 carrier:1
          collisions:0 txqueuelen:1000 
          RX bytes:179510 (179.5 KB)  TX bytes:34053 (34.0 KB)

lo        Link encap:Local Loopback  
          inet addr:127.0.0.1  Mask:255.0.0.0
          inet6 addr: ::1/128 Scope:Host
          UP LOOPBACK RUNNING  MTU:65536  Metric:1
          RX packets:11570 errors:0 dropped:0 overruns:0 frame:0
          TX packets:11570 errors:0 dropped:0 overruns:0 carrier:0
          collisions:0 txqueuelen:1000 
          RX bytes:1269162 (1.2 MB)  TX bytes:1269162 (1.2 MB)

tap0      Link encap:Ethernet  HWaddr 96:50:a4:e0:68:f3  
          inet addr:192.168.7.1  Bcast:192.168.7.255  Mask:255.255.255.255
          inet6 addr: fe80::9450:a4ff:fee0:68f3/64 Scope:Link
          UP BROADCAST RUNNING MULTICAST  MTU:1500  Metric:1
          RX packets:0 errors:0 dropped:0 overruns:0 frame:0
          TX packets:1 errors:0 dropped:0 overruns:0 carrier:0
          collisions:0 txqueuelen:1000 
          RX bytes:0 (0.0 B)  TX bytes:90 (90.0 B)

wlp3s0    Link encap:Ethernet  HWaddr c4:85:08:ae:34:18  
          inet addr:192.168.1.34  Bcast:192.168.1.255  Mask:255.255.255.0
          inet6 addr: fe80::2d4d:ee05:dbb:2274/64 Scope:Link
          UP BROADCAST RUNNING MULTICAST  MTU:1500  Metric:1
          RX packets:1813991 errors:0 dropped:932 overruns:0 frame:0
          TX packets:1215879 errors:0 dropped:0 overruns:0 carrier:0
          collisions:0 txqueuelen:1000 
          RX bytes:2141881174 (2.1 GB)  TX bytes:509655353 (509.6 MB)
```

Start a light node on the host, with support for WebSockets by using the --ws and --wsaddr flags. Also, `wsorigins` is used so our node accepts websockets requests from the QEMU machine:
```
$ geth --syncmode "light" --ws --wsaddr "192.168.1.7" --wsorigins "http://qemumips"

```

On the QEMU MIPS emulation, login and use geth to attach to the host's light node:
```
Poky (Yocto Project Reference Distro) 2.5.3 qemumips /dev/ttyS0

qemumips login: root
root@qemumips:~# geth attach ws://192.168.7.1:8546
WARN [06-21|00:28:03.728] Sanitizing cache to Go's GC limits       provided=1024 updated=80
Welcome to the Geth JavaScript console!

instance: Geth/v1.8.27-stable-4bcc0a37/linux-amd64/go1.10.4
 modules: eth:1.0 net:1.0 rpc:1.0 web3:1.0

> 
```

Finally, print some information on geth's console from the QEMU MIPS emulation:
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

That's it! You have connected your QEMU MIPS emulation to the Ethereum Blockchain! Of course, real smart contracts and relevant interactions would take a lot more work. This tutorial is only meant to act as a proof of concept of meta-ethereum.

---

Copyright (C) 2019 Bernardo Rodrigues <bernardoaraujor@gmail.com>

Released under [GPLv3](https://github.com/bernardoaraujor/meta-ethereum/blob/master/LICENSE).
