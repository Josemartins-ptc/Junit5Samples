package anotations.repeatable;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import lombok.extern.log4j.Log4j2;

/**
 * We can access RepetitionInfo from
 * inside our test methods.
 */
@Log4j2
public class RepeatInfoAccessTest {

	@RepeatedTest(value = 3, name = "TestName {currentRepetition}/{totalRepetitions}")
	void iCanRunMultipleTimes(RepetitionInfo repetitionInfo) {

		int step = repetitionInfo.getCurrentRepetition();
		log.debug("I am in Step {}", step);
	}

	@RepeatedTest(value = 4)
	void useStepAsAVariable(RepetitionInfo repetitionInfo) {

		int step = repetitionInfo.getCurrentRepetition();
		int total = repetitionInfo.getTotalRepetitions();
		log.debug("Hey I can do Math with this :) progress = {} %", (step * 100) / total);
	}
}
