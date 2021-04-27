# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"
BUILD_OPTIMIZATION = "-Og -g -feliminate-unused-debug-types -pipe"
SELECTED_OPTIMIZATION = "${BUILD_OPTIMIZATION}"

SRC_URI = "git://gitlab.com/librespacefoundation/gr-soapy.git;protocol=https"

# Modify these as desired
PV = "2.1.3.1"
SRCREV = "e4be7402cf845d7bbd86ea66605904b8fdee7631"

S = "${WORKDIR}/git"
BBCLASSEXTEND += "native"

inherit cmake python3native

# NOTE: unable to map the following CMake package dependencies: Doxygen SoapySDR
DEPENDS = "\
	swig-native \
	gnuradio \
	boost \
	python3 \
	python3-six \
	gnuradio \
	soapysdr \
	gmp \
	orc \
	git \
"

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = " \
	-DPYTHON_LIBRARY=${STAGING_LIBDIR}/lib${PYTHON_DIR}${PYTHON_ABI}.so \
	-DPYTHON_INCLUDE_DIR=${STAGING_INCDIR}/${PYTHON_DIR}${PYTHON_ABI} \
    -DGR_PYTHON_DIR=lib/${PYTHON_DIR}${PYTHON_ABI}/site-packages \
	"

FILES_${PN} += "\
  ${datadir}/gnuradio/grc/blocks \
  ${PYTHON_SITEPACKAGES_DIR}/soapy \
"

