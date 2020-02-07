package anotations.standard;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LifeCycle {

	@BeforeAll
	static void classInit() {

		log.debug("I'm executed Once per class");
	}

	@BeforeEach
	void setup() {

		log.debug("I'm executed once before each test method");
	}

	@Test
	void testOne() {
		log.info("I'm running test one");
		assertThat(true).isTrue();
	}

	@Test
	void testTwo() {
		log.info("I'm running test Two");
		assertThat(true).isTrue();
	}

	@AfterEach
	void clear() {

		log.info("I'm executed after each test");
	}

	@AfterAll
	static void tearDown() {

		log.debug("I'm executed after all tests run");
	}
}
