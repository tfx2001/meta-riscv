do_install:append:freedom-u540() {
    sed -i -e 's#/bin/start_getty#/sbin/getty#g' ${D}${sysconfdir}/inittab
    sed -i '/tty1/d' ${D}${sysconfdir}/inittab
}

do_install:append:visionfive2() {
    sed -i 's/vt102/xterm-256color/g' ${D}${sysconfdir}/inittab
}
