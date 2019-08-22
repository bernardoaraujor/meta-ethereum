# meta-ethereum

![meta-ethereum](https://github.com/bernardoaraujor/meta-ethereum/raw/master/meta-ethereum.png  "meta-ethereum")

The upcoming wave of blockchain-enabled IoT devices is creating a rising demand for embedded support of the [Ethereum](https://www.ethereum.org/) protocol. Examples of projects that aim to run Ethereum inside embedded systems are:

 * **EthRaspbian**: <https://ethraspbian.com>
 * **cpp-ethereum-cross**: <https://github.com/doublethinkco/cpp-ethereum-cross/>
 * **EthEmbedded**: <http://ethembedded.com>
 * **Oaken Project**: <https://www.oakeninnovations.com/>

The [**Yocto Project**](https://www.yoctoproject.org/) is an open source collaboration project that helps developers create custom Linux-based systems regardless of the hardware architecture. Meanwhile, [**OpenEmbedded**](http://www.openembedded.org/wiki/Main_Page) is a build automation framework and cross-compile environment used to create Linux distributions for embedded devices.

Together, these projects provides a flexible set of tools and a space where embedded developers worldwide can share technologies, software stacks, configurations, and best practices that can be used to create tailored Linux images for embedded and IoT devices, or anywhere a customized Linux OS is needed. 

The **meta-ethereum** OpenEmbedded Layer aims to provide recipes for Ethereum related programs, tools and libraries in order to support the Ethereum blockchain on a large variety of embedded devices. Please note that the meta-* is an OE layer naming convention, and this repository has nothing to do with the [Ethereum Meta](https://ethermeta.com/) project.

Currently, we aim to provide recipes for the following:

 * **geth/go-ethereum** [v1.8.27 - stable]: <https://github.com/ethereum/go-ethereum>
 * **aleth/cpp-ethereum** [v1.6.0 - under development]: <https://github.com/ethereum/aleth>
 * **parity** [v2.4.6 - planned]: <https://github.com/paritytech/parity-ethereum>
 
Any collaborations (issues, patches, pull requests, suggestions) are more than welcome: <bernardoaraujor@gmail.com>

---
## Dependencies

The meta-ethereum layer depends on:

	URI: git://git.openembedded.org/openembedded-core
	layers: meta
	branch: rocko, sumo, thud, warrior

	URI: git://git.openembedded.org/meta-openembedded
	layers: meta-oe
	branch: rocko, sumo, thud, warrior
	
After we start the development of recipes for **parity** in the near future, it is very likely that there will also be dependency to the **meta-rust** layer.	


---
## Tutorials
You can find some tutorials in the `docs` folder:

 - [Running geth on a QEMUlated machine](https://github.com/bernardoaraujor/meta-ethereum/blob/master/docs/qemu_tutorial.md) ([YouTube](https://youtu.be/IZ6nDKGy7NA))
 - [Running geth on a BeagleBone Black](https://github.com/bernardoaraujor/meta-ethereum/blob/master/docs/bbb_tutorial.md)
 - [Running geth on an RCar H3 Starter Kit](https://github.com/bernardoaraujor/meta-ethereum/blob/master/docs/rcar_tutorial.md) ([YouTube](https://www.youtube.com/watch?v=X7G0kdYsrg8))
 
---
## Donations
If you find meta-ethereum useful, please consider making a donation:

 - **BTC**: 3NUDRd9hZV2Y8cm6J7u6qmdQVNoWhJrjen
 - **LTC**: LSpyeCjxY28z9VpYjoGJGE8QZLxUL7Rk6c
 - **ETH**: 0x6028475be0b1cf8a566bec7ff4b4f5d28406266e
---
## License

meta-ethereum is released under the [GPLv3](https://github.com/bernardoaraujor/meta-ethereum/blob/master/LICENSE).
