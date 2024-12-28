DESCRIPTION = "PWM fan SysVinit script."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit update-rc.d systemd

SRC_URI = "\
	file://pwm-fan.sh \
	file://pwm-fan.service \
"

INITSCRIPT_NAME = "pwm-fan.sh"
INITSCRIPT_PARAMS = "start 99 S . stop 20 0 1 6 ."

SYSTEMD_SERVICE:${PN} = "pwm-fan.service"

do_install() {
	if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
		install -d ${D}${bindir}
		install -d ${D}${systemd_system_unitdir}
		install -m 0755 ${WORKDIR}/pwm-fan.sh ${D}${bindir}/pwm-fan
		install -m 0644 ${WORKDIR}/pwm-fan.service ${D}${systemd_system_unitdir}/pwm-fan.service
	else
		install -d ${D}${sysconfdir}/init.d
		install -m 0755 ${WORKDIR}/pwm-fan.sh ${D}${sysconfdir}/init.d/pwm-fan
	fi
}
