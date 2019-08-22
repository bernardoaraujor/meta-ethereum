# Copyright (C) 2019 Bernardo Rodrigues <bernardoaraujor@gmail.com>

SUMMARY = "Official Go implementation of the Ethereum protocol"
DESCRIPTION = "geth is the command line interface for running a full ethereum node implemented in Go."
HOMEPAGE = "https://geth.ethereum.org"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI = "git://github.com/ethereum/go-ethereum.git;branch=release/1.8;tag=v${PV}"

inherit go

GO_IMPORT = "github.com/ethereum/go-ethereum"
GO_LINKSHARED = ""
PTEST_ENABLED = "0"

LDFLAGS += "-lpthread"

RDEPENDS_${PN}-dev += " gawk bash"
