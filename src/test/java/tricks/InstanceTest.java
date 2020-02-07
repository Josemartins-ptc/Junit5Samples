package tricks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class InstanceTest {

	private List<String> list = new ArrayList<>();

	@Test
	void testOne() {

		list.add("someData");
		assertEquals(1, list.size());
	}

	@Test
	void testTwo() {

		list.add("someMoreData");
		list.add("EvenMoreData");
		assertEquals(2, list.size());
	}
}
