package exceptions.assertjway;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import samples.NumberToLiteral;

public class AssertJException {


	@Test
	void asserJAssertassertThat() {

		NumberToLiteral numberToLiteral = new NumberToLiteral();

		assertThatThrownBy(() -> numberToLiteral.getAProblem())
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("ERROR")
				.hasMessageStartingWith("E")
				.hasMessageContaining("RO")
				.hasStackTraceContaining("Illegal");
	}

	//wrappers

	void assertJWrapper() {

		NumberToLiteral numberToLiteral = new NumberToLiteral();
		assertThatIllegalArgumentException().isThrownBy(() -> {
			numberToLiteral.getAProblem();
		});
	}

	@Test
	void assertJSoftAssertions() {

		NumberToLiteral numberToLiteral = new NumberToLiteral();

		SoftAssertions.assertSoftly(soft -> {

			soft.assertThat(2).isEqualTo(3);

		});
	}


}
