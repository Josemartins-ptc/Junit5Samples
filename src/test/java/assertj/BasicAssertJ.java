package assertj;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BasicAssertJ {

	@Test
	void basicOne() {

		assertThat(Boolean.TRUE).isTrue();
	}

	@Test
	void basicTwo() {

		assertThat(Boolean.FALSE).isFalse();
	}

	@Test
	void basicThree() {

		assertThat(2).isGreaterThan(1);
	}

	@Test
	void basicFour() {

		assertThat("C").isBetween("B", "D");
	}
}
