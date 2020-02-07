package samples;

public class NumberToLiteral {
	public static final String[] unitsDictionary = {
			"", "one", "two", "three", "four", "five", "six", "seven",
			"eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
			"fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
	};

	public static final String[] tensDictionary = {
			"",        // 0
			"",        // 1
			"twenty",  // 2
			"thirty",  // 3
			"forty",   // 4
			"fifty",   // 5
			"sixty",   // 6
			"seventy", // 7
			"eighty",  // 8
			"ninety"   // 9
	};

	public static String convert(final int n) {
		if (n < 0) {
			return "minus " + convert(Math.abs(n));
		}

		if (n < 20) {
			return unitsDictionary[n];
		}

		if (n < 100) {
			return tensDictionary[n / 10] + ((n % 10 != 0) ? " " : "") + unitsDictionary[n % 10];
		}

		if (n < 1000) {
			return unitsDictionary[n / 100] + " hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
		}

		if (n < 1000000) {
			return convert(n / 1000) + " thousand" + ((n % 1000 != 0) ? " " : "") + convert(n % 1000);
		}

		if (n < 1000000000) {
			return convert(n / 1000000) + " million" + ((n % 1000000 != 0) ? " " : "") + convert(n % 1000000);
		}

		return convert(n / 1000000000) + " billion" + ((n % 1000000000 != 0) ? " " : "") + convert(n % 1000000000);
	}

	public void getAProblem() {

		throw new IllegalArgumentException("ERROR");
	}

}
