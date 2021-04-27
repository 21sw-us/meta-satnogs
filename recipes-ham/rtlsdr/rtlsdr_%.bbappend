EXTRA_OECMAKE = " -DINSTALL_UDEV_RULES=ON"
BUILD_OPTIMIZATION = "-Og -g -feliminate-unused-debug-types -pipe"
SELECTED_OPTIMIZATION = "${BUILD_OPTIMIZATION}"

do_install_append() {
	install -d -m 755 ${D}/etc/udev/rules.d
	install -c -m 644 ${WORKDIR}/git/rtl-sdr.rules ${D}/etc/udev/rules.d
}
