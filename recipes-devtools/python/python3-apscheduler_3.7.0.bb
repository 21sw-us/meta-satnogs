HOMEPAGE = "https://github.com/agronholm/apscheduler"
SUMMARY = "Python scheduler"
DESCRIPTION = "Advanced Python Scheduler (APScheduler) is a Python library that lets you schedule your Python code to be executed later, either just once or periodically."
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=f0e423eea5c91e7aa21bdb70184b3e53"

PYPI_PACKAGE = "APScheduler"

SRC_URI[md5sum] = "d660346824f3784b87da262dc3952569"
SRC_URI[sha256sum] = "1cab7f2521e107d07127b042155b632b7a1cd5e02c34be5a28ff62f77c900c6a"

inherit pypi setuptools3

DEPENDS += "python3-setuptools-scm-native"
