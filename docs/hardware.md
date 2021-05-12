# Hardware

## Requirements

Note: taken from [Ethereum Docs](https://ethereum.org/en/developers/docs/nodes-and-clients/#hardware).

Hardware requirements differ by client but generally are not that high since the node just needs to stay synced. Don't confuse it with mining which requires much more computing power. Sync time and performance do improve with more powerful hardware however.

Minimum and recommended requirements can be found below, however the key part is the disk space. Syncing the Ethereum blockchain is very input/output intensive. It is best to have a solid-state drive (SSD). To run an Ethereum client on slower storage media, you will need at least 8GB of RAM to use as a cache.

### Minimum

- CPU with 2+ cores
- 4 GB RAM with SSD, 8 GB+ with other media (eMMC, SD, HDD).
- 8 MBit/s bandwidth

### Recommended

- Fast CPU with 4+ cores
- 16 GB+ RAM
- Fast SSD with at least 500 GB free space
- 25+ MBit/s bandwidth

### Disk

Depending on which software and sync mode are you going to use, hundreds of GBs of disk space is need. Approximate numbers and growth can be found below:

<table class="tg">
<thead>
  <tr>
    <th class="tg-nrix">Node</th>
    <th class="tg-nrix">Disk Size (fast sync)<br></th>
    <th class="tg-nrix">Disk Size (full archieve)</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td class="tg-nrix">geth<br></td>
    <td class="tg-nrix">400GB+</td>
    <td class="tg-nrix">6TB+</td>
  </tr>
  <tr>
    <td class="tg-nrix">openethereum</td>
    <td class="tg-nrix">280GB+</td>
    <td class="tg-nrix">6TB+</td>
  </tr>
</tbody>
</table>
