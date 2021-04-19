package org.springframework.boot.tests.application.config;

import org.springframework.util.StopWatch;

public class StopWatchTest {

	public static void main(String[] args) throws InterruptedException {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("task1");
Thread.sleep(1000);
		stopWatch.stop();

		System.out.println(stopWatch.prettyPrint());
	}
}
