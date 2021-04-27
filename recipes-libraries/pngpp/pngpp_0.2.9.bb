# PNG++ aims to provide simple yet powerful C++ interface to libpng, the
# PNG reference implementation library. 

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=22f1274bc9ba324d163e423c1baf0e19"

SRC_URI = " \
	http://download.savannah.nongnu.org/releases/pngpp/png%2B%2B-${PV}.tar.gz \
	"

SRC_URI[md5sum] = "92863df3bee625d707cebc0e749c10df"
SRC_URI[sha1sum] = "024ce64b0a473984637ab2be1ef535cc744488e9"
SRC_URI[sha256sum] = "abbc6a0565122b6c402d61743451830b4faee6ece454601c5711e1c1b4238791"
SRC_URI[sha384sum] = "17d40e0c93fe43dba810de72f0aaade2e17af63879de2c29e947255db65e8a76a43bf47cacb316158121613b5b1d6ad0"
SRC_URI[sha512sum] = "905e037faf26eef9ca1d9508471dde9f480f41a87d72133057865078b2fd040b1cf84727ece48d79117d615fdfbc0a749fec7dbe362366763e2017865a7fe132"

S = "${WORKDIR}/png++-${PV}"
BBCLASSEXTEND += "native"

inherit pkgconfig 
DEPENDS += "libpng"

# normal builds
CFLAGS = "`pkg-config libpng --cflags` -I${S}"
CPPFLAGS = "`pkg-config libpng --cflags` -I${S}"
LDFLAGS = "`pkg-config libpng --libs`"

# native builds
BUILD_CFLAGS = "`pkg-config libpng --cflags` -I${S}"
BUILD_CPPFLAGS = "`pkg-config libpng --cflags` -I${S}"
BUILD_LDFLAGS = "`pkg-config libpng --libs` -lpng"

do_compile () {
	oe_runmake PREFIX=${STAGING_DIR_TARGET} LIBPNG_CONFIG=true
}

do_install () {
	oe_runmake install PREFIX="${D}${prefix}"
}

