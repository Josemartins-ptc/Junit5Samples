package parameterized;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class VSource {


	@ParameterizedTest
	@ValueSource(strings = {"", " ", "\t", "\n"})
	void testForEmptiness(final String value) {

		assertTrue(value.isBlank());
	}

	@ParameterizedTest
	@NullSource
	void testForEmptinessByNull(final String value) {

		assertTrue(value == null);
	}

	@ParameterizedTest
	@ValueSource(strings = {"", " ", "\t", "\n"})
	@NullSource
	void testForCompleteEmptiness(final String value) {

		assertTrue(value == null || value.isBlank());
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void testWithValueSource(int value) {
		assertTrue(value > 0 && value < 4);
	}
}
