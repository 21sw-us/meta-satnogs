# SatNOGS Rotator Un-Winder Utility

# This utility can be used to move a SatNOGS rotator station to an 'absolute' position between passes.
# This position could either be a 'home' location, or the start of the next pass. This helps 'unwind'
# a rotator prior to a pass occuring. 

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/darksidelemm/satnogs-unwinder;protocol=https"

PV = "1.0+git${SRCPV}"
SRCREV = "cfb6db94fc320a3f22bdf6b1b1b9cc8bcf6b6e22"

S = "${WORKDIR}/git"
RDEPENDS_${PN} = "python3 bash satnogs-client"

do_compile () {
	cat > ${B}/unwind.sh <<-EOF
	#!/usr/bin/env bash
	source /etc/default/satnogs-client

	python3 /usr/bin/unwind.py --home_azimuth=0.0 --home_elevation=0.0 --station_id=\${SATNOGS_STATION_ID}
	EOF
}

do_install () {
	install -D -m 0755 ${S}/unwind.py ${D}/usr/bin/unwind.py
	install -D -m 0755 ${B}/unwind.sh ${D}/usr/bin/unwind.sh
}

