package exceptions.junit5way;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class JunitException {

	@Test
	void exceptionNewApproach() {

		assertThrows(NumberFormatException.class, () -> {
			Integer.parseInt("NaN");
		});
	}

	@Test
	void weCanAlsoValidateMessagesOrCodes() {

		Throwable expected = assertThrows(NumberFormatException.class, () -> {
			Integer.parseInt("NaN");
		});

		assertEquals("For input string: \"NaN\"", expected.getMessage());
	}
}
