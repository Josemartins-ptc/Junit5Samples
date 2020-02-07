package testfactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInfo;

import samples.OddNumberProvider;

public class OddNumberProviderTest {

	@TestFactory
	Stream<DynamicTest> oddNumberTest(TestInfo testInfo) {

		OddNumberProvider oddNumberProvider = new OddNumberProvider();

		return oddNumberProvider.getRandomSizeSetOfOdds().stream()
				.map(
						n -> DynamicTest.dynamicTest(
								"Testing value " + n + " for oddness ",
								() -> assertTrue(n % 2 != 0)
						)
				);
	}
}
