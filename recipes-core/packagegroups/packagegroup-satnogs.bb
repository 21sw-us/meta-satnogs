SUMMARY = "SatNOGS Ground Station Packages"
DESCRIPTION = "Packages and dependencies for running a SatNOGS ground station"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} += "\
	gpredict \
	hamlib \
	devmem2 \
    avrdude \
    gnuradio \
    gr-satnogs \
    gr-soapy \
    libfec \
    rtlsdr \
    satnogs-client \
    satnogs-unwinder \
    satnogs-flowgraphs \
    satnogs-decoders \
    soapysdr \
    "
