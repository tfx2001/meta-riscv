#!/bin/sh

umask 077

start() {
    echo 0 > /sys/class/pwm/pwmchip0/export
    echo 20000 > /sys/class/pwm/pwmchip0/pwm0/period
    echo 17500 > /sys/class/pwm/pwmchip0/pwm0/duty_cycle
    echo 1 > /sys/class/pwm/pwmchip0/pwm0/enable
}
stop() {
    echo 0 > /sys/class/pwm/pwmchip0/pwm0/enable
	echo 0 > /sys/class/pwm/pwmchip0/unexport
}
restart() {
	stop
	start
}

case "$1" in
  start)
	start
	;;
  stop)
	stop
	;;
  restart|reload)
	restart
	;;
  *)
	echo "Usage: $0 {start|stop|restart}"
	exit 1
esac

exit $?
