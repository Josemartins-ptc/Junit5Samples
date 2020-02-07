package samples;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OddNumberProvider {

	/**
	 * We don't know how many will be returned.
	 *
	 * @return
	 */
	public Set<Integer> getRandomSizeSetOfOdds() {

		int maxRange = randomNumberInRange(2, 30);

		return IntStream.rangeClosed(1, maxRange).sorted()
				.filter(n -> n % 2 != 0).boxed().collect(Collectors.toCollection(LinkedHashSet::new));
	}

	private static int randomNumberInRange(int min, int max) {

		Random r = new Random();
		return r.ints(min, (max + 1)).findFirst().getAsInt();

	}
}
