# Copyright (C) 2021 Bernardo Rodrigues <barodrigues@protonmail.com>

SUMMARY = "Official Go implementation of the Ethereum protocol"
DESCRIPTION = "Go Ethereum is one of the three original implementations of the Ethereum protocol. It is written in Go, fully open source and licensed under the GNU LGPL v3."
HOMEPAGE = "https://geth.ethereum.org"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/LGPL-3.0;md5=bfccfe952269fff2b407dd11f2f3083b"

inherit go go-mod systemd

GO_IMPORT = "github.com/ethereum/go-ethereum"
SRC_URI = " \
            git://github.com/ethereum/go-ethereum.git;tag=v${PV};destsuffix=${BPN}-${PV}/src/${GO_IMPORT} \
            file://go-ethereum.service \
"

GO_LINKSHARED = ""
GOBUILDFLAGS_append = " -modcacherw"

LDFLAGS += "-lpthread"

RDEPENDS_${PN}-dev += " gawk bash systemd"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "go-ethereum.service"
SYSTEMD_AUTO_ENABLE = "disable"
FILES_${PN} += " go-ethereum.service"

do_install_append(){

    # create systemd directory
    install -m 0755 -d ${D}${systemd_system_unitdir}

    # populate systemd service file
    install -m 0755 ${WORKDIR}/go-ethereum.service ${D}${systemd_system_unitdir}

}
