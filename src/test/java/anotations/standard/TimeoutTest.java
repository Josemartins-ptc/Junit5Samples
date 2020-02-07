package anotations.standard;

import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TimeoutTest {

	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	void timeoutTest() {
		try {
			TimeUnit.MILLISECONDS.sleep(510);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	void timeoutTestTwo() {
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	void assertTimeoutTest() {

		assertTimeout(Duration.ofMillis(50), () -> delay100Miliseconds());
	}

	void delay100Miliseconds() {
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
