for i in {1..5}; do echo -n "$i : ";sync; echo 1 > /proc/sys/vm/drop_caches && date && mpstat && free -m;sleep 60; done
