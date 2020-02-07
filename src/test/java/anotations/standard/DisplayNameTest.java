package anotations.standard;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DisplayNameTest {

	@Test
	@DisplayName("A very Important Test")
	void testOne() {
		assertThat(true).isTrue();
	}

	@Test
	@DisplayName("An even more Important test")
	void testTwo() {
		assertThat(true).isTrue();
	}
}
