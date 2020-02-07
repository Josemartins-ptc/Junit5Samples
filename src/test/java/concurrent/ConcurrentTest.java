package concurrent;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Execution(ExecutionMode.CONCURRENT)
public class ConcurrentTest {

	@ParameterizedTest
	@MethodSource("range")
	void testWithRangeMethodFrom_1_100(int argument) {

		log.debug("in 1-100 Testing value {}", argument);
		assertEquals(0, argument);
	}

	static IntStream range() {
		return IntStream.range(1, 100);
	}

	@ParameterizedTest
	@MethodSource("range2")
	void testWithRangeMethodFrom_100_200(int argument) throws InterruptedException {

		log.debug("in 100-200 Testing value {}", argument);
		assertEquals(0, argument);
	}

	static IntStream range2() {
		return IntStream.range(101, 200);
	}


}
