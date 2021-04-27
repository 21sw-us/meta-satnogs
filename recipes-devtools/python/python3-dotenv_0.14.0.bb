HOMEPAGE = "https://github.com/pedroburon/dotenv"
SUMMARY = "Python Dot Env Handler"
DESCRIPTION = "Shell Command and Library to write and read .env like files."
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=55ee2c3471d386636a719c8ccac40b31"

PYPI_PACKAGE = "python-dotenv"

SRC_URI[md5sum] = "80906b481060e266ebaa6748c192dc04"
SRC_URI[sha256sum] = "8c10c99a1b25d9a68058a1ad6f90381a62ba68230ca93966882a4dbc3bc9c33d"

inherit pypi setuptools3
