package com.graphite.stress;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stresser {

	private static List<Integer> timerOptions = new ArrayList<>();
	
	static {
		
		timerOptions.add(1);
		timerOptions.add(2);
		timerOptions.add(3);
		timerOptions.add(4);
		timerOptions.add(5);
		timerOptions.add(10);
		timerOptions.add(20);
		timerOptions.add(64);
		timerOptions.add(128);
		timerOptions.add(256);
		timerOptions.add(384);
		timerOptions.add(650);
		timerOptions.add(975);
		timerOptions.add(1956);
		timerOptions.add(3912);
		timerOptions.add(4887);
		timerOptions.add(7824);
		timerOptions.add(9780);
		timerOptions.add(13699);
		
	}
	
	public static void main(String args[]) throws IOException, InterruptedException {
		
		if (args.length != 6) {
			System.err.println("Usage:\n");
			System.err.println("java -jar stresser.jar host port numHosts numTimers interval debug\n");
			System.err.println("\thost: the Graphite endpoint");
			System.err.println("\tport: the Graphite port");
			System.err.println("\tnumHosts: the number of hosts to simulate publishing from");
			System.err.println("\tnumTimers: the number of timers to create (options: " + timerOptions.toString() + ")");
			System.err.println("\tinterval: the metric publishing interval (i.e. 10 seconds)");
			System.err.println("\tdebug: true/false to enable/disable debug mode");
			System.exit(1);
		}
		
		String graphiteEndpoint = String.valueOf(args[0]);
		int graphitePort = Integer.valueOf(args[1]);
		int numHosts = Integer.valueOf(args[2]);
		int numTimers = Integer.valueOf(args[3]);
		int publishingInterval = Integer.valueOf(args[4]);
		boolean isVerbose = Boolean.valueOf(args[5]);
		
		boolean validTimerOption = false;
		for (int option : timerOptions) {
			if (numTimers == option) {
				validTimerOption = true;
			}
		}
		
		if (!validTimerOption) {
			System.out.println("Timer option " + numTimers + " is not valid, please select a valid one...");
			System.out.println("Timer options: " + timerOptions.toString());
			System.exit(1);
		}
		
		List<String> metricNames = new ArrayList<String>();
		List<String> accumulatorList = new ArrayList<String>();
		
		// increase the number of letters to increase the number of metrics accordingly
		if (numTimers == 1) {
			
			metricNames.add("a"); // 1
			
		} else if (numTimers == 2) {
			
			metricNames.add("a"); // 1 each
			metricNames.add("b");
			
		} else if (numTimers == 3) {
			
			metricNames.add("a"); // 1 each
			metricNames.add("b");
			metricNames.add("c");
			
		} else if (numTimers == 4) {
			
			metricNames.add("a"); // 1 each
			metricNames.add("b");
			metricNames.add("c");
			metricNames.add("d");
			
		} else if (numTimers == 5) {
			
			metricNames.add("a"); // 1 each
			metricNames.add("b");
			metricNames.add("c");
			metricNames.add("d");
			metricNames.add("e");
			
		} else if (numTimers == 10) {
			
			metricNames.add("a"); // 1 each
			metricNames.add("b");
			metricNames.add("c");
			metricNames.add("d");
			metricNames.add("e");
			metricNames.add("f");
			metricNames.add("g");
			metricNames.add("h");
			metricNames.add("i");
			metricNames.add("j");
			
		} else if (numTimers == 20) {
			
			metricNames.add("a"); // 1 each
			metricNames.add("b");
			metricNames.add("c");
			metricNames.add("d");
			metricNames.add("e");
			metricNames.add("f");
			metricNames.add("g");
			metricNames.add("h");
			metricNames.add("i");
			metricNames.add("j");
			
			metricNames.add("k");
			metricNames.add("l");
			metricNames.add("m");
			metricNames.add("n");
			metricNames.add("o");
			metricNames.add("p");
			metricNames.add("q");
			metricNames.add("r");
			metricNames.add("s");
			metricNames.add("t");
			
		} else if (numTimers == 64) {
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("a", "b", "c", "d").toArray(new String[0])); // 64
			metricNames.addAll(accumulatorList);
			
		} else if (numTimers == 128) {
		
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("a", "b", "c", "d").toArray(new String[0])); // 64
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("e", "f", "g", "h").toArray(new String[0])); // 64
			metricNames.addAll(accumulatorList);
			
		} else if (numTimers == 256) {
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("a", "b", "c", "d").toArray(new String[0])); // 64
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("e", "f", "g", "h").toArray(new String[0])); // 64
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("i", "j", "k", "l").toArray(new String[0])); // 64
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("m", "n", "o", "p").toArray(new String[0])); // 64
			metricNames.addAll(accumulatorList);
			
		} else if (numTimers == 384) {
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("a", "b", "c", "d").toArray(new String[0])); // 64
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("e", "f", "g", "h").toArray(new String[0])); // 64
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("i", "j", "k", "l").toArray(new String[0])); // 64
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("m", "n", "o", "p").toArray(new String[0])); // 64
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("q", "r", "s", "t").toArray(new String[0])); // 64
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("u", "v", "w", "x").toArray(new String[0])); // 64
			metricNames.addAll(accumulatorList);
			
		} else if (numTimers == 650) {
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("a", "b", "c", "d", "e").toArray(new String[0])); // 325
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("f", "g", "h", "i", "j").toArray(new String[0])); // 325
			metricNames.addAll(accumulatorList);
			
		} else if (numTimers == 975) {
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("a", "b", "c", "d", "e").toArray(new String[0])); // 325
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("f", "g", "h", "i", "j").toArray(new String[0])); // 325
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("k", "l", "m", "n", "o").toArray(new String[0])); // 325
			metricNames.addAll(accumulatorList);
			
		} else if (numTimers == 1956) {
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("a", "b", "c", "d", "e", "f").toArray(new String[0])); // 1956
			metricNames.addAll(accumulatorList);
			
		} else if (numTimers == 3912) {
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("a", "b", "c", "d", "e", "f").toArray(new String[0])); // 1956
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("g", "h", "i", "j", "k", "l").toArray(new String[0])); // 1956
			metricNames.addAll(accumulatorList);
			
			
		} else if (numTimers == 4887) {
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("a", "b", "c", "d", "e", "f").toArray(new String[0])); // 1956
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("g", "h", "i", "j", "k", "l").toArray(new String[0])); // 1956
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("m", "n", "o", "p", "q").toArray(new String[0])); // 325
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("r", "s", "t", "u", "v").toArray(new String[0])); // 325
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("w", "x", "y", "z", "0").toArray(new String[0])); // 325
			metricNames.addAll(accumulatorList);
			
		} else if (numTimers == 7824) {
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("a", "b", "c", "d", "e", "f").toArray(new String[0])); // 1956
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("g", "h", "i", "j", "k", "l").toArray(new String[0])); // 1956
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("m", "n", "o", "p", "q", "r").toArray(new String[0])); // 1956
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("s", "t", "u", "v", "w", "x").toArray(new String[0])); // 1956
			metricNames.addAll(accumulatorList);
			
		} else if (numTimers == 9780) {
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("a", "b", "c", "d", "e", "f").toArray(new String[0])); // 1956
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("g", "h", "i", "j", "k", "l").toArray(new String[0])); // 1956
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("m", "n", "o", "p", "q", "r").toArray(new String[0])); // 1956
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("s", "t", "u", "v", "w", "x").toArray(new String[0])); // 1956
			metricNames.addAll(accumulatorList);
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("y", "z", "0", "1", "2", "3").toArray(new String[0])); // 1956
			metricNames.addAll(accumulatorList);
			
		} else if (numTimers == 13699) {
			
			accumulatorList.clear();
			accumulatorList = Permutator.permute(Arrays.asList("a", "b", "c", "d", "e", "f", "g").toArray(new String[0])); // 13699
			metricNames.addAll(accumulatorList);
			
		}
		
		System.out.println("Initializing " + metricNames.size() + " timers - publishing " + metricNames.size() * 15 * numHosts + " metrics every " + publishingInterval + " seconds from " + numHosts + " host(s)");
		
		StresserHelper helper = new StresserHelper(graphiteEndpoint, graphitePort, publishingInterval);
		
		while (true) {

			// For each of the metric names generated, initialize a timer and report the metric continuously.
			for (String metricName : metricNames) {

				helper.publishMetric(metricName, numHosts, isVerbose);

			}
			
			Thread.sleep(5000);

		}
		
		
		
	}
	
}