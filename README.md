#Stresser

I have a Stresser application that will publish a fixed amount of metrics to the carbon-cache regularly. It uses the Coda Hale metrics library internally and more specifically, it uses a Timer object to collect data. The Stresser receives a couple of parameters:

* Graphite host: in our case, the server housing our carbon cache
* Graphite port: in our case, the carbon cache port
* Number of hosts: to simulate publishing from
* Number of timers: each timer generates 15 distinct metrics 
* Publishing interval
* Debug mode: true/false - logs the metrics that are published

You can run the Stresser using the following command:

```
Usage:

java -jar stresser.jar host port numHosts numTimers interval debug

	host: the Graphite endpoint
	port: the Graphite port
	numHosts: the number of hosts to simulate publishing from
	numTimers: the number of timers to create (options: [1, 2, 3, 4, 5, 10, 20, 64, 128, 256, 384, 650, 975, 1956, 3912, 4887, 7824, 9780, 13699])
	interval: the metric publishing interval (i.e. 10 seconds)
	debug: true/false to enable/disable debug mode
```

```
$ java -jar stresser.jar localhost 2003 1 128 10 true
Initializing 128 timers - publishing 1920 metrics every 10 seconds from 1 host(s)
Publishing metric: STRESS.host.ip-0.com.graphite.stresser.a
Publishing metric: STRESS.host.ip-0.com.graphite.stresser.ab
Publishing metric: STRESS.host.ip-0.com.graphite.stresser.abc
Publishing metric: STRESS.host.ip-0.com.graphite.stresser.abcd
...
```
The Coda Hale metrics library generates 15 distinct metrics per timer:

```
#ls -l /opt/graphite/storage/whisper/STRESS/host/ip-0/com/graphite/stresser/feg/
total 300
-rw-r--r--. 1 root root 17308 Jun  4 11:22 count.wsp
-rw-r--r--. 1 root root 17308 Jun  4 11:22 m15_rate.wsp
-rw-r--r--. 1 root root 17308 Jun  4 11:22 m1_rate.wsp
-rw-r--r--. 1 root root 17308 Jun  4 11:22 m5_rate.wsp
-rw-r--r--. 1 root root 17308 Jun  4 11:22 max.wsp
-rw-r--r--. 1 root root 17308 Jun  4 11:22 mean_rate.wsp
-rw-r--r--. 1 root root 17308 Jun  4 11:22 mean.wsp
-rw-r--r--. 1 root root 17308 Jun  4 11:22 min.wsp
-rw-r--r--. 1 root root 17308 Jun  4 11:22 p50.wsp
-rw-r--r--. 1 root root 17308 Jun  4 11:22 p75.wsp
-rw-r--r--. 1 root root 17308 Jun  4 11:22 p95.wsp
-rw-r--r--. 1 root root 17308 Jun  4 11:22 p98.wsp
-rw-r--r--. 1 root root 17308 Jun  4 11:22 p999.wsp
-rw-r--r--. 1 root root 17308 Jun  4 11:22 p99.wsp
-rw-r--r--. 1 root root 17308 Jun  4 11:22 stddev.wsp
```

### More Information

See the [Stress Testing Carbon Caches](http://www.franklinangulo.com/blog/2014/5/25/graphite-series-5-stress-testing-carbon-caches) blog post for more details.
