# Copyright (C) 2019 Bernardo Rodrigues <bernardoar@protonmail.com>

SUMMARY = "Aleth – Ethereum C++ client, tools and libraries"
DESCRIPTION = "The collection of C++ libraries and tools for Ethereum, formerly known as cpp-ethereum project. This includes the full Ethereum client aleth."
HOMEPAGE = "http://cpp-ethereum.org/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

GCCVERSION = "5.2%"

SRC_URI = "\
	   gitsm://github.com/ethereum/aleth.git;tag=v1.6.0 \
	   file://0001-fix-gtest_main.patch \
	   file://0002-remove-CMake-ExternalProjects-dependency.patch \
	   file://BoostConfig.cmake \
	   file://BoostTargets.cmake \
	   file://cryptoppConfig.cmake \
	   file://cryptoppTargets.cmake \
	   file://libjson-rpc-cppConfig.cmake \
	   file://libjson-rpc-cppTargets.cmake \
	   file://FindLibFF.cmake \
	   file://LibFFTargets.cmake \
           file://FindSecp256k1.cmake \
	  "

S = "${WORKDIR}/git"

CMAKE_WORK_DIR = "${S}/cmake"

EXTRA_OECMAKE += "\
                   -DHUNTER_ENABLED=OFF \
		   -DTESTS=OFF \
		   -DCMAKE_BUILD_TYPE=Release \
		   -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
		   -DBoost_DIR=${CMAKE_WORK_DIR} \
		   -Dcryptopp_DIR=${CMAKE_WORK_DIR} \
		   -Dlibjson-rpc-cpp_DIR=${CMAKE_WORK_DIR} \
		   -DLibFF_DIR=${CMAKE_WORK_DIR} \
		   -Dlibff_LIBRARY=${RECIPE_SYSROOT}/usr/lib/libff.a \
"

inherit cmake

DEPENDS = "boost jsoncpp snappy libcryptopp ethash jsonrpc libmicrohttpd scrypt leveldb rocksdb gtest yaml-cpp crc32c secp256k1 libff"

OECMAKE_FIND_ROOT_PATH_MODE_PROGRAM = "BOTH"

do_populate_cmake(){
    cp ${WORKDIR}/BoostConfig.cmake ${S}/cmake
    cp ${WORKDIR}/BoostTargets.cmake ${S}/cmake
    cp ${WORKDIR}/cryptoppConfig.cmake ${S}/cmake
    cp ${WORKDIR}/cryptoppTargets.cmake ${S}/cmake
    cp ${WORKDIR}/libjson-rpc-cppConfig.cmake ${S}/cmake
    cp ${WORKDIR}/libjson-rpc-cppTargets.cmake ${S}/cmake
    cp ${WORKDIR}/FindLibFF.cmake ${S}/cmake
    cp ${WORKDIR}/LibFFTargets.cmake ${S}/cmake
    cp ${WORKDIR}/FindSecp256k1.cmake ${S}/cmake
}

addtask do_populate_cmake after do_unpack before do_configure
