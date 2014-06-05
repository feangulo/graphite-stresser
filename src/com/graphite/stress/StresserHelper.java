package com.graphite.stress;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.codahale.metrics.graphite.Graphite;
import com.codahale.metrics.graphite.GraphiteReporter;

public class StresserHelper {

	private MetricRegistry metricRegistry;
	
	private final Graphite graphite;
	
	private final GraphiteReporter graphiteReporter;
	
	public StresserHelper(String graphiteHostname, Integer graphitePort, Integer publishingInterval) {
		
		metricRegistry = new MetricRegistry();
		
		graphite = new Graphite(new InetSocketAddress(graphiteHostname, graphitePort));
		
		graphiteReporter = GraphiteReporter.forRegistry(metricRegistry)
										   .convertRatesTo(TimeUnit.SECONDS)
										   .convertDurationsTo(TimeUnit.MILLISECONDS)
										   .build(graphite);
		
		graphiteReporter.start(publishingInterval, TimeUnit.SECONDS);
		
	}
	
	public void publishMetric(String metricName, boolean isVerbose) throws IOException {

		String ipAddress = InetAddress.getLocalHost().getHostAddress().replace(".", "-");
		String metricPrefix = "STRESS.host." + ipAddress + ".com.graphite.stresser";
		
		String fullMetricName = MetricRegistry.name(metricPrefix, metricName);
		
		if (isVerbose) {
			System.out.println("Publishing metric: " + fullMetricName);
		}
		
		final Timer timer = metricRegistry.timer(fullMetricName);

		final Timer.Context context = timer.time();
		try {
			
			// doing mostly nothing
			long sleepTime = (int) Math.random() * 100;
			Thread.sleep(sleepTime);
			
		} catch (Exception ex) {
			System.out.println("Encountered exception: " + ex);
		} finally {
			context.stop();
		}
		
	}
	
	
	
}