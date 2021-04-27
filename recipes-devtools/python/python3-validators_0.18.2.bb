HOMEPAGE = "https://github.com/kvesteri/validators"
SUMMARY = "Python data validation for Humans"
DESCRIPTION = "Python has all kinds of data validation tools, but every one of them seems to require defining a schema or form. I wanted to create a simple validation library where validating a simple value does not require defining a form or a schema."
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c4bb3fb5c2325bfca6c6358ba1d89e6"

PYPI_PACKAGE = "validators"

SRC_URI[md5sum] = "eeda94e9b38fd2d54e9c28537b79cf06"
SRC_URI[sha256sum] = "37cd9a9213278538ad09b5b9f9134266e7c226ab1fede1d500e29e0a8fbb9ea6"

inherit pypi setuptools3
