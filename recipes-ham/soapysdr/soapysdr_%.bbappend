BBCLASSEXTEND += "native"
BUILD_OPTIMIZATION = "-Og -g -feliminate-unused-debug-types -pipe"
SELECTED_OPTIMIZATION = "${BUILD_OPTIMIZATION}"

PV = "0.7.2"
SRCREV = "cbdcb115239d9747b93184c5cf13bf18a8964d52"

inherit python3native

DEPENDS += "\
    python3 \
    swig-native \
    "

RDEPENDS_${PN} += "\
    soapyrtlsdr \
    "

RDEPENDS_${PN}_class-native += ""

EXTRA_OECMAKE = " \
    -DSOAPY_SDR_ROOT=/usr \
    -DCMAKE_LIBRARY_PATH=${STAGING_LIBDIR} \
    -DFEC_INCLUDE_DIRS=${S}/libfec \
    -DPYTHON_LIBRARY=${STAGING_LIBDIR}/lib${PYTHON_DIR}${PYTHON_ABI}.so \
    -DPYTHON3_LIBRARY=${STAGING_LIBDIR}/lib${PYTHON_DIR}${PYTHON_ABI}.so \
    -DPYTHON3_INCLUDE_DIR=${STAGING_INCDIR}/${PYTHON_DIR}${PYTHON_ABI} \
    "

DISABLED_OEMAKE = " \
    -DPYTHON_INSTALL_DIR=${STAGING_LIBDIR}/${PYTHON_DIR}${PYTHON_ABI}/site-packages \
    -DPYTHON3_INSTALL_DIR=${STAGING_LIBDIR}/${PYTHON_DIR}${PYTHON_ABI}/site-packages \
    "

FILES_${PN} += "\
    ${PYTHON_SITEPACKAGES_DIR}/SoapySDR.py \
    ${PYTHON_SITEPACKAGES_DIR}/_SoapySDR.so \
    "
