# PACKAGECONFIG options are qtgui5 grc uhd logging orc ctrlport zeromq staticlibs
PACKAGECONFIG := "grc"
BBCLASSEXTEND += "native"
BUILD_OPTIMIZATION = "-Og -g -feliminate-unused-debug-types -pipe"
SELECTED_OPTIMIZATION = "${BUILD_OPTIMIZATION}"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI_append = "\
	file://0001-boost.patch \
	"

# dont change this without comprehensive testing of satnogs packages
SRCREV = "38f5ab7b4d5c683dfb9a493fd3e5c6de3e7d2c89"
PV = "3.8.0+git${SRCPV}"
GITHUB_USER = "gnuradio"
GIT_BRANCH = "maint-3.8"

# workaround for bug where python3native path would get embedded into a SWIG file
# PYTHON_EXECUTABLE must be an absolute path here
EXTRA_OECMAKE_prepend = "\
    -DPYTHON_EXECUTABLE=${PYTHON} \
    "

DEPENDS += "\
    python3-pygobject-native \
    python3-pyyaml-native \
    gtk+3 \
    gtk+3-native \
    pango-native \
    cairo-native \
    python3-pycairo-native \
	mpir \
	"

PROVIDES += "${GR_PACKAGES}"
RPROVIDES_${PN}_class-native += "${GR_PACKAGES}"

# install this file so we can use it in other builds
do_install_append () {
	install -D ${S}/grc/scripts/grcc ${D}${bindir}/grcc
}
