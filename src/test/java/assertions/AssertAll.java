package assertions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AssertAll {

	@Test
	void assertAllFailLater() {
		final String someString = "someString";
		assertAll(
				() -> assertEquals("one", "two"),
				() -> assertNull(someString),
				() -> assertTrue(false == true)
		);
	}
}
