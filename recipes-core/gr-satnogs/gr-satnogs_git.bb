# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464 \
                    file://lib/libfec/LICENSE;md5=64e57bd01e1bf2a1350b7689ce33983c"
BUILD_OPTIMIZATION = "-Og -g -feliminate-unused-debug-types -pipe"
SELECTED_OPTIMIZATION = "${BUILD_OPTIMIZATION}"

SRC_URI = "\
    git://gitlab.com/librespacefoundation/satnogs/gr-satnogs.git;protocol=https \
    file://0001-boost-unit-tests.patch \
    "

# Modify these as desired
PV = "2.2.0.0"
SRCREV = "cdab69d757f182d392bf8a1497d2fbbf983b2da4"
S = "${WORKDIR}/git"
BBCLASSEXTEND += "native"

inherit cmake python3native

# require external libfec-native for gen_ccsds scripts
DEPENDS = " \
    alsa-lib \
    boost \
    boost-native \
    cppunit \
    fftw \
    git \
    git-native \
    gmp \
    gnuradio \
    gsl \
    jsoncpp \
    libfec-native \
    libogg \
    libpng \
    libvorbis \
    log4cpp \
    mpir \
    nlohmann-json \
    pngpp \
    python3 \
    python3-mako-native \
    python3-numpy \
    python3-six-native \
    swig \
    swig-native \
    volk \
    "

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = " \
    -DCMAKE_LIBRARY_PATH=${STAGING_LIBDIR} \
    -DFEC_INCLUDE_DIRS=${S}/libfec \
    -DPYTHON_LIBRARY=${STAGING_LIBDIR}/lib${PYTHON_DIR}${PYTHON_ABI}.so \
    -DPYTHON_INCLUDE_DIR=${STAGING_INCDIR}/${PYTHON_DIR}${PYTHON_ABI} \
    -DGR_PYTHON_DIR=${PYTHON_SITEPACKAGES_DIR} \
    -DMPIR_INCLUDE_DIR=${STAGING_INCDIR} \
    -DMPIRXX_LIBRARY=${STAGING_LIBDIR} \
    -DENABLE_GRC=1 \
    "

FILES_${PN} += "\
    /usr/lib/python3.8/site-packages/satnogs \
    /usr/share/gnuradio/grc/blocks \
"
