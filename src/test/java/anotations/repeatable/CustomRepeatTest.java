package anotations.repeatable;

import org.junit.jupiter.api.RepeatedTest;

import lombok.extern.log4j.Log4j2;

/**
 * The {currentRepetition} and {totalRepetitions} are the placeholders
 * for the current repetition and the total number of repetitions.
 * These values are automatically provided by JUnit at the runtime,
 * and no additional configuration is required.
 */
@Log4j2
public class CustomRepeatTest {

	@RepeatedTest(value = 3, name = "TestName {currentRepetition}/{totalRepetitions}")
	void iCanRunMultipleTimes() {
		log.debug("I'm running");
	}

}
