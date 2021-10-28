#! /bin/sh
#
# start/stop the secure shell daemon

case "$1" in
'start')

	# Start the ssh daemon
	if [ -x /usr/sbin/sshd ]; then
		echo "starting SSHD daemon"
		/usr/sbin/sshd &
	fi
	;;

'stop')
	# Stop the ssh daemon
	/usr/bin/pkill -x sshd
	;;
*)
	echo "usage: /etc/init.d/sshd {start|stop}"
;;
