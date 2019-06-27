# Copyright (C) 2019 Bernardo Rodrigues <bernardoar@protonmail.com>

SUMMARY = "C++ library for Finite Fields and Elliptic Curves "
HOMEPAGE = "http://www.scipr-lab.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "gitsm://github.com/scipr-lab/libff.git"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS = " gmp"

EXTRA_OECMAKE += "\
		  -DGMP_INCLUDE_DIR=${RECIPE_SYSROOT}/usr/include \
		  -DGMP_LIBRARY=${RECIPE_SYSROOT}/usr/lib/libgmpxx.so \
		  -DCURVE=ALT_BN128 -DPERFORMANCE=Off -DWITH_PROCPS=Off \
		  -DUSE_PT_COMPRESSION=Off \
		  -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
"

inherit cmake

# avoid wrong GMP_NUMB_BITS from implicit CMake import from sysroot-native
do_configure_prepend(){
    rm -f ${RECIPE_SYSROOT_NATIVE}/usr/include/gmp.h
}
