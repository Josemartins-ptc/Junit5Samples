package parameterized;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lombok.extern.log4j.Log4j2;
import samples.NumberToLiteral;
import samples.UpperCaseProvider;

@Log4j2
public class CsvParameterized {

	@ParameterizedTest
	@CsvSource({"spock, SPOCK", "kiRk, KIRK", "borg,BORG"})
	void testWithParametersFromAnnotation(final String provided, final String expected) {

		assertEquals(expected, UpperCaseProvider.get(provided));
	}

	@ParameterizedTest
	@CsvSource({"1,one", "200,two hundred", "1012,one thousand twelve", "-6,minus six"})
	void convertToLiteralTest(final int number, final String expectedLiteral) {

		log.debug("Converting {} to literal reads -> {}", number, expectedLiteral);
		assertEquals(expectedLiteral, NumberToLiteral.convert(number));
	}

}
