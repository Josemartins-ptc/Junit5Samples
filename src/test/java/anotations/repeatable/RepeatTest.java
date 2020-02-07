package anotations.repeatable;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import lombok.extern.log4j.Log4j2;

/**
 * This kind of tests has a problem.
 * In the report we do not have proper names.
 * Only the repetition.
 */
@Log4j2
public class RepeatTest {

	@BeforeEach
	void beforeEachTest() {
		log.debug("Before Each Test");
		log.debug("=====================");
	}

	@RepeatedTest(3)
	void iCanRunMultipleTimes() {
		log.debug("I'm running");
	}

	@AfterEach
	void afterEachTest() {
		log.debug("After Each Test");
		log.debug("=====================");
	}

}
