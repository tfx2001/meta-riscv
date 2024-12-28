DESCRIPTION = "PWM fan SysVinit script."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit update-rc.d

SRC_URI = "file://pwm-fan.sh"

INITSCRIPT_NAME = "pwm-fan.sh"
INITSCRIPT_PARAMS = "start 99 S . stop 20 0 1 6 ."

do_install() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/pwm-fan.sh ${D}${sysconfdir}/init.d
}
