# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "SatNOGS Client"
HOMEPAGE = "https://gitlab.com/librespacefoundation/satnogs/satnogs-client"
LICENSE = "AGPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=eb1e647870add0502f8f010b19de32af"
BUILD_OPTIMIZATION = "-Og -g -feliminate-unused-debug-types -pipe"
SELECTED_OPTIMIZATION = "${BUILD_OPTIMIZATION}"

SRC_URI = " \
	git://gitlab.com/librespacefoundation/satnogs/satnogs-client.git;protocol=https \
	file://0001-setup-cfg.patch \
	"

PV = "1.4"
SRCREV = "246403336bab13ee73f84e6059f5b7f8eef58f6f"

S = "${WORKDIR}/git"

inherit setuptools3

# APScheduler~=3.6.0
# python-dotenv~=0.14.0
# requests~=2.24.0
# validators~=0.18.0
# python-dateutil~=2.8.0
# ephem~=3.7.7.0
# pytz
# numpy~=1.16.0
# h5py~=2.10.0
# matplotlib~=3.3.0
# gps~=3.19
# sentry-sdk~=0.18.0

RDEPENDS_${PN} += " \
	python3-core \
	python3-datetime \
	python3-distutils \
	python3-io \
	python3-json \
	python3-logging \
	python3-netclient \
	python3-shell \
	gpsd \
	python3-pygps \
	hamlib \
	python3-matplotlib \
	python3-numpy \
	python3-pytz \
	python3-sentry-sdk (=0.18.0) \
	python3-urllib3 \
	python3-requests \
	python3-h5py \
	python3-configparser \
	python3-dateutil \
	python3-pyephem \
	python3-certifi \
	python3-six \
	python3-idna \
	python3-kiwisolver \
	python3-cycler \
	python3-pillow \
	python3-tzlocal \
	python3-pyparsing \
	python3-decorator \
	python3-chardet \
	python3-dotenv \
	python3-validators \
	python3-apscheduler \
	git \
	hdf5 \
	satnogs-client-ansible \
	"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    cx_Freeze.dist
#    py2exe.build_exe
#    py2exe.distutils_buildexe
#    setuptools.command.build_py
#    setuptools.command.sdist
