package parameterized;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MethSource {


	@ParameterizedTest
	@MethodSource("nameProvider")
	void allNames_start_withCapital_A(final String name) {

		log.debug("current name {}", name);

		assertTrue(name.startsWith("A"));
	}


	static Stream<String> nameProvider() {
		return Stream.of("Anthony", "Allison", "Adeline", "Adam");
	}

	@ParameterizedTest
	@MethodSource("collectionProvider")
	void allNames_start_withCapital_J(final BigDecimal amount) {

		log.debug("amount under test {}", amount);

		assertTrue(amount.compareTo(BigDecimal.ZERO) > 0);
	}

	static Iterable<BigDecimal> collectionProvider() {
		final BigDecimal amount1 = BigDecimal.ONE;
		final BigDecimal amount2 = BigDecimal.TEN;
		final BigDecimal amount3 = new BigDecimal(15);

		return Arrays.asList(amount1, amount2, amount3);
	}


	@ParameterizedTest
	@MethodSource("range")
	void testWithRangeMethodSource(int argument) {
		assertNotEquals(9, argument);
	}

	static IntStream range() {
		return IntStream.range(0, 20).skip(10);
	}

	// more than one argument

	@ParameterizedTest
	@MethodSource("stringIntAndListProvider")
	void testWithMultiArgMethodSource(String box, int quantity, List<String> axis) {

		log.debug("parameter 1 - {} | parameter 2 - {} | parameter 3 {}", box, quantity, axis);
		assertTrue(box.contains("Box"));
		assertTrue(quantity >= 1 && quantity <= 5);
		assertTrue(axis.size() >= 2);
	}

	static Stream<Arguments> stringIntAndListProvider() {
		return Stream.of(
				arguments("SquareBox", 1, Arrays.asList("x", "y")),
				arguments("RectangularBox", 5, Arrays.asList("x", "y", "z"))
		);
	}

}
