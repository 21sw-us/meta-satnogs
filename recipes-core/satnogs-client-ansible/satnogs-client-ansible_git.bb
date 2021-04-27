# Ansible playbook to make the installation procedure for SatNOGS client easier.
# This recipe uses ansible-playbook to translate templates to static files for installation
# This recipe does not attempt to run the ansible playbooks in this package or expect them
# to be executed on the device.  It only installs the systemd service files.
LICENSE = "AGPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=eb1e647870add0502f8f010b19de32af"

SRC_URI = "\
    git://gitlab.com/librespacefoundation/satnogs/satnogs-client-ansible.git;protocol=https \
    file://0001-satnogs-client-service.patch \
    file://jinja2.yml \
    file://satnogs-client \
    file://hamlib-utils \
    "

PV = "1.0+git${SRCPV}"
SRCREV = "c9c2b5039c5e1d4f6ea568bdc5e772377e8fa68a"

S = "${WORKDIR}/git"
DEPENDS += "\
    python3-ansible-native \
    "
HAMLIB_UTILS_USER = "hamlib-utils"
SATNOGS_CLIENT_USER = "satnogs"

inherit systemd
SYSTEMD_SERVICE_${PN} = "satnogs-client.service rotctld.service rigctld.service"
SYSTEMD_AUTO_ENABLE = "enable"

inherit useradd
USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "\
    --system --home-dir /var/run/${SATNOGS_CLIENT_USER} --shell /bin/false -G dialout --user-group ${SATNOGS_CLIENT_USER};\
    --system --home-dir /var/run/${HAMLIB_UTILS_USER} --shell /bin/false -G dialout --user-group ${HAMLIB_UTILS_USER};\
"

do_compile () {
    USERS="hamlib_utils_user=${HAMLIB_UTILS_USER} satnogs_client_user=${SATNOGS_CLIENT_USER}"
    ansible-playbook -e "${USERS} input_file=${S}/roles/satnogs-client/templates/etc/systemd/system/satnogs-client.service.j2 output_file=${B}/satnogs-client.service " ${WORKDIR}/jinja2.yml
    ansible-playbook -e "${USERS} input_file=${S}/roles/hamlib-utils/templates/etc/systemd/system/rotctld.service.j2 output_file=${B}/rotctld.service " ${WORKDIR}/jinja2.yml
    ansible-playbook -e "${USERS} input_file=${S}/roles/hamlib-utils/templates/etc/systemd/system/rigctld.service.j2 output_file=${B}/rigctld.service " ${WORKDIR}/jinja2.yml
}

do_install () {
    install -D -m 644 ${B}/satnogs-client.service ${D}${systemd_unitdir}/system/satnogs-client.service
    install -D -m 644 ${WORKDIR}/satnogs-client ${D}${sysconfdir}/default/satnogs-client
    install -d ${D}/var/lib/${SATNOGS_CLIENT_USER}/
    ln -s /usr/bin ${D}/var/lib/${SATNOGS_CLIENT_USER}/bin
    install -D -m 644 ${B}/rotctld.service ${D}${systemd_unitdir}/system/rotctld.service
    install -D -m 644 ${B}/rigctld.service ${D}${systemd_unitdir}/system/rigctld.service
    install -D -m 644 ${WORKDIR}/hamlib-utils ${D}${sysconfdir}/default/hamlib-utils
}

FILES_${PN} += "\
    ${systemd_unitdir}/system/satnogs-client.service \
    ${sysconfdir}/default/satnogs-client \
    ${systemd_unitdir}/system/rotctld.service \
    ${systemd_unitdir}/system/rigctld.service \
"
