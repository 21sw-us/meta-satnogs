LICENSE = "LGPL-2.0"
LIC_FILES_CHKSUM = "file://lesser.txt;md5=2cc41cbc9eccda3e7419e519635b7a32"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
BUILD_OPTIMIZATION = "-Og -g -feliminate-unused-debug-types -pipe"
SELECTED_OPTIMIZATION = "${BUILD_OPTIMIZATION}"

SRC_URI = "\
    git://github.com/quiet/libfec.git;protocol=https\
    file://0001-ldconfig.patch \
    "

# need gen_ccsds binaries to build libfec for non-native target
BBCLASSEXTEND += "native"
DEPENDS += "libfec-native"

PV = "2.1.1+git${SRCPV}"
SRCREV = "9750ca0a6d0a786b506e44692776b541f90daa91"
S = "${WORKDIR}/git"

inherit autotools

FILES_${PN} += " \
    /usr \
    /usr/lib \
    /usr/share \
    /usr/include \
    /usr/lib/libfec.so \
    /usr/share/man \
    /usr/share/man/man3 \
    /usr/share/man/man3/dsp.3 \
    /usr/share/man/man3/simd-viterbi.3 \
    /usr/share/man/man3/rs.3 \
    /usr/include/fec.h \
"

do_compile_append() {
	cp ${S}/fec.h ${S}/*3 .
}

do_install_append_class-native () {
    install -d ${D}${bindir}
    install -m 755 -p ${B}/gen_ccsds ${B}/gen_ccsds_tal ${D}${bindir}/
}
