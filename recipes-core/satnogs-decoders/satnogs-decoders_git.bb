# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "SatNOGS Decoders"
HOMEPAGE = "https://gitlab.com/librespacefoundation/satnogs/satnogs-decoders"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
#   contrib/manage/LICENSE
LICENSE = "AGPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=eb1e647870add0502f8f010b19de32af \
                    file://contrib/manage/LICENSE;md5=4ae09d45eac4aa08d013b5f2e01c67f6"

SRC_URI = "git://gitlab.com/librespacefoundation/satnogs/satnogs-decoders.git;protocol=https"

# Modify these as desired
PV = "1.21.0+git${SRCPV}"
SRCREV = "2e683e594ecd25153a63927b81114d0dfd22e669"

S = "${WORKDIR}/git"

inherit setuptools3 python3native

RDEPENDS_${PN} += "python3-core python3-datetime python3-distutils python3-json python3-netclient"

do_compile_append() {
    export PATH
    cd ${S}
    ./contrib/docker-ksc.sh
}

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    ConfigParser
#    cx_Freeze.dist
#    py2exe.build_exe
#    py2exe.distutils_buildexe
#    pytest
#    setuptools.command.build_py
#    setuptools.command.sdist
