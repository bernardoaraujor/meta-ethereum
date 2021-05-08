# meta-ethereum

![meta-ethereum](meta-ethereum.png)

The upcoming wave of blockchain-enabled IoT devices is creating a rising demand for embedded support of the [Ethereum](https://www.ethereum.org/) protocol. Examples of projects that aim to run Ethereum inside embedded systems are:

 * **Ethereum on ARM**: <https://ethereum-on-arm-documentation.readthedocs.io>
 * **EthRaspbian**: <https://ethraspbian.com>
 * **cpp-ethereum-cross**: <https://github.com/doublethinkco/cpp-ethereum-cross/>
 * **EthEmbedded**: <http://ethembedded.com>
 * **Oaken Project**: <https://www.oakeninnovations.com/>

The [**Yocto Project**](https://www.yoctoproject.org/) is an open source collaboration project that helps developers create custom Linux-based systems regardless of the hardware architecture. Meanwhile, [**OpenEmbedded**](http://www.openembedded.org/wiki/Main_Page) is a build automation framework and cross-compile environment used to create Linux distributions for embedded devices.

Together, these projects provides a flexible set of tools and a space where embedded developers worldwide can share technologies, software stacks, configurations, and best practices that can be used to create tailored Linux images for embedded and IoT devices, or anywhere a customized Linux OS is needed.

The **meta-ethereum** OpenEmbedded Layer aims to provide recipes for Ethereum related programs, tools and libraries in order to support the Ethereum blockchain on a large variety of embedded devices. Please note that the meta-* is an OE layer naming convention, and this repository has nothing to do with the [Ethereum Meta](https://ethermeta.com/) project.

<table class="tg">
<thead>
  <tr>
    <th class="tg-nrix"></th>
    <th class="tg-nrix" colspan="3">ETH1</th>
    <th class="tg-nrix" colspan="4">ETH2</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td class="tg-nrix">PROJECT</td>
    <td class="tg-nrix"><a href="https://github.com/status-im/nimbus-eth1">Nimbus</a></td>
    <td class="tg-nrix"><a href="https://geth.ethereum.org/">go-ethereum</a></td>
    <td class="tg-nrix"><a href="https://github.com/openethereum/openethereum">OpenEthereum</a></td>
    <td class="tg-nrix"><a href="https://github.com/status-im/nimbus-eth2">Nimbus</a></td>
    <td class="tg-nrix"><a href="https://trinity.ethereum.org/">Trinity</a></td>
    <td class="tg-nrix"><a href="https://github.com/prysmaticlabs/prysm">Prysm</a></td>
    <td class="tg-nrix"><a href="https://github.com/sigp/lighthouse">Lighthouse</a></td>
  </tr>
  <tr>
    <td class="tg-nrix">STATUS</td>
    <td class="tg-nrix">planned</td>
    <td class="tg-nrix"><a href="https://github.com/oe-eth/meta-ethereum/blob/master/recipes-ethereum/go-ethereum/go-ethereum_1.10.3.bb">v1.10.3</a></td>
    <td class="tg-nrix"><a href="https://github.com/oe-eth/meta-ethereum/blob/master/recipes-ethereum/openethereum/openethereum_3.2.5.bb">v3.2.5</a> (dev)</td>
    <td class="tg-nrix">planned</td>
    <td class="tg-nrix">planned</td>
    <td class="tg-nrix">planned</td>
    <td class="tg-baqh">planned</td>
  </tr>
  <tr>
    <td class="tg-nrix">EXECUTABLES<br></td>
    <td class="tg-nrix"></td>
    <td class="tg-nrix">geth<br>clef<br>devp2p<br>abigen<br>abidump<br>bootnode<br>evm<br>rlpdump<br>puppeth<br>checkpoint-admin<br>faucet<br>ethkey</td>
    <td class="tg-nrix">openethereum<br>evmbin<br>ethstore<br>ethabi<br>whisper<br></td>
    <td class="tg-nrix">nimbus_beacon_node<br>nimbus_signing_process<br>nimbus_validator_client<br>ncli<br>ncli_db</td>
    <td class="tg-nrix">trinity</td>
    <td class="tg-nrix"></td>
    <td class="tg-baqh"></td>
  </tr>
</tbody>
</table>

Any collaborations (issues, patches, pull requests, suggestions) are more than welcome: <barodrigues@protonmail.com>

---
## Dependencies

The meta-ethereum layer depends on:

```
  URI: git://git.openembedded.org/openembedded-core
  layers: meta
  branch: hardknott

  URI: git://github.com/meta-rust/meta-rust
  layers: meta-rust
  branch: master

  URI: git://github.com/oe-nim/meta-nim
  layers: meta-nim
  branch: main
```

---
## Donations
If you find meta-ethereum useful, please consider making a donation:

- **BTC** `1A3bVGz9VWCsngsFZGe78MYEaj82dYFTdh`
- **BCH** `qp3nds93p30pq03yk4eg09a82znd23ezfq299ptuhx`
- **ETH** `0x35cd665c0F6EF207935547aD480E5980131f81FC`
- **Gitcoin Grants**: https://gitcoin.co/grants/2564/oe-eth
---
## License

meta-ethereum is released under the [GPLv3](https://github.com/oe-eth/meta-ethereum/blob/master/LICENSE).
