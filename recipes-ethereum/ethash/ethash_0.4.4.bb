# Copyright (C) 2019 Bernardo Rodrigues <bernardoaraujor@gmail.com>

SUMMARY = "C/C++ implementation of Ethash – the Ethereum Proof of Work algorithm"
HOMEPAGE = "https://github.com/ethereum/wiki/wiki/Ethash/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/chfast/ethash.git;tag=v0.4.4"
S = "${WORKDIR}/git"

EXTRA_OECMAKE += "\
		  -DHUNTER_ENABLED=OFF \
		  -DETHASH_BUILD_TESTS=OFF \
		  "

inherit cmake
