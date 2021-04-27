LICENSE = "LGPLv3 & GPLv3"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=b52f2d57d10c4f7ee67a7eb9615d5d24 \
                    file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://github.com/wbhart/mpir.git"

PV = "3.0+git${SRCPV}"
SRCREV = "b3367eb13eca95b3a204beaca5281a2c3b4c66a6"

S = "${WORKDIR}/git"

inherit autotools

EXTRA_OECONF = " --enable-cxx"

DEPENDS += "\
	yasm-native \
	"

BBCLASSEXTEND += "native"
