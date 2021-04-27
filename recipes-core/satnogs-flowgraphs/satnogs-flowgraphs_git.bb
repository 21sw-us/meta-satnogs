# Recipe created by recipetool

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
BUILD_OPTIMIZATION = "-Og -g -feliminate-unused-debug-types -pipe"
SELECTED_OPTIMIZATION = "${BUILD_OPTIMIZATION}"

SRC_URI = "git://gitlab.com/librespacefoundation/satnogs/satnogs-flowgraphs.git;protocol=https"

PV = "1.3"
SRCREV = "19d1dbc7665fdd1a2fae40bf8362edd63a8d3953"

S = "${WORKDIR}/git"

inherit cmake python3native

# for pre-compiled native binary libraries used at build time
PYTHONPATH = "\
${STAGING_DIR_NATIVE}${PYTHON_SITEPACKAGES_DIR}:\
${STAGING_DIR_NATIVE}${PYTHON_SITEPACKAGES_DIR}/gnuradio/grc:\
${STAGING_DIR_NATIVE}${PYTHON_SITEPACKAGES_DIR}/satnogs:\
${STAGING_DIR_NATIVE}${PYTHON_SITEPACKAGES_DIR}/gnuradio/gr:\
"

LD_LIBRARY_PATH = "\
${STAGING_DIR_NATIVE}/usr/lib:\
${STAGING_DIR_NATIVE}${PYTHON_SITEPACKAGES_DIR}/satnogs:\
${STAGING_DIR_NATIVE}${PYTHON_SITEPACKAGES_DIR}/soapy:\
"

GRC_BLOCKS_PATH = "${STAGING_DATADIR_NATIVE}/gnuradio/grc/blocks"

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = " \
	-DPYTHON_LIBRARY=${STAGING_LIBDIR}/lib${PYTHON_DIR}${PYTHON_ABI}.so \
	-DPYTHON_INCLUDE_DIR=${STAGING_INCDIR}/${PYTHON_DIR}${PYTHON_ABI} \
	-DGR_PYTHON_DIR=${PYTHON_SITEPACKAGES_DIR} \
	-DPYTHONPATH=${PYTHONPATH} \
	-DLD_LIBRARY_PATH=${LD_LIBRARY_PATH} \
	"

DEPENDS += "\
	gnuradio \
	gr-soapy \
	gr-satnogs \
	libfec \
	soapysdr \
	gr-soapy \
"

# gnuradio-native needed for grcc
# python3-pyyaml-native needed for yaml
# gr-satnogs-native for flowgraph dependencies
# soapysdr-native and gr-soapy-native needed for flowgraphs
DEPENDS += "\
	gnuradio-native \
	python3-pyyaml-native \
	gr-soapy-native \
	soapysdr-native \
	gr-satnogs-native \
	satnogs-client \
"

RDEPENDS_${PN} += "\
	gr-satnogs \
	gr-soapy \
	soapysdr \
	gnuradio \
	gnuradio-analog \
	gnuradio-gru \
	gnuradio-audio \
	gnuradio-digital \
	gnuradio-gr \
	gnuradio-grc \
	gnuradio-blocks \
	gnuradio-filter \
	gnuradio-modtool \
	gnuradio-fft \
	gnuradio-doc \
	gnuradio-trellis \
	gnuradio-channels \
	gnuradio-wavelet \
	gnuradio-pmt \
	gnuradio-gr \
	gnuradio-fec \
	gnuradio-runtime \
"

do_configure_prepend() {
	# find the native python dependencies in the build environment
	export PYTHONPATH=${PYTHONPATH}
	export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}
}

do_compile_prepend() {
	# find the native python dependencies in the build environment
	export PYTHONPATH=${PYTHONPATH}
	export LD_LIBRARY_PATH=${LD_LIBRARY_PATH}

	# this prevents the blocks['options'] traceback
	export GRC_BLOCKS_PATH=${GRC_BLOCKS_PATH}

	# call grcc through python to avoid a bad interpretter line
	find ${S} -name CMakeLists.txt -exec sed -i -e "s,COMMAND.*grcc,COMMAND ${PYTHON} ${STAGING_BINDIR_NATIVE}/grcc," {} \;
}
