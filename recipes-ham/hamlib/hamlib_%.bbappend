inherit python3-dir python3native
BUILD_OPTIMIZATION = "-Og -g -feliminate-unused-debug-types -pipe"
SELECTED_OPTIMIZATION = "${BUILD_OPTIMIZATION}"

DEPENDS += "\
    python3 \
    libxcrypt \
    swig-native \
    "

EXTRA_OECONF += "\
    --with-python-binding \
    PYTHON=${PYTHON} \
    PYTHON_SITE_PKG=${STAGING_DIR}${PYTHON_SITEPACKAGES_DIR} \
    PYTHON_CPPFLAGS=-I${STAGING_INCDIR}/${PYTHON_DIR}${PYTHON_ABI} \
    PYTHON_LIBS=-L${STAGING_LIBDIR}/lib \
    CFLAGS=-l${PYTHON_DIR} \
"

EXTRA_OECONF_native += "\
    --with-python-binding \
    PYTHON=${PYTHON} \
    PYTHON_SITE_PKG=${STAGING_DIR_NATIVE}${PYTHON_SITEPACKAGES_DIR} \
    PYTHON_CPPFLAGS=-I${STAGING_INCDIR_NATIVE}/${PYTHON_DIR}${PYTHON_ABI} \
    PYTHON_LIBS=-L${STAGING_LIBDIR_NATIVE}/lib \
    CFLAGS=-l${PYTHON_DIR} \
"

FILES_${PN} += "\
    ${PYTHON_SITEPACKAGES_DIR}/_Hamlib.so \
    ${PYTHON_SITEPACKAGES_DIR}/Hamlib.py \
    ${PYTHON_SITEPACKAGES_DIR}/__pycache__/Hamlib.cpython-38.opt-1.pyc \
    ${PYTHON_SITEPACKAGES_DIR}/__pycache__/Hamlib.cpython-38.pyc \
"
