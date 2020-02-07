package parameterized;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

import java.math.BigDecimal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import enums.PurchaseStatus;
import lombok.extern.log4j.Log4j2;
import sampleobjects.Purchase;

@Log4j2
public class EnumParameterized {

	@ParameterizedTest
	@EnumSource(PurchaseStatus.class)
	void testEnumSource(PurchaseStatus status) {

		log.debug(status);
		final Purchase purchase = new Purchase(1, status, BigDecimal.ONE);

		assertSame(purchase.getStatus(), status);
	}

	@ParameterizedTest
	@EnumSource
	void testEnumSourceWithAutoDetection(PurchaseStatus status) {

		log.debug(status);
		final Purchase purchase = new Purchase(1, status, BigDecimal.ONE);

		assertTrue(purchase.getStatus() == status);
	}

	@ParameterizedTest
	@EnumSource(names = {"CREATED", "COMMITED"})
	void testWithEnumSourceInclude(PurchaseStatus status) {

		log.debug(status);
		Purchase purchase = new Purchase(1L, status, BigDecimal.ONE);

		assertFalse(purchase.isFinalState());
	}

	@ParameterizedTest
	@EnumSource(mode = EXCLUDE, names = {"FAILED"})
	void testWithEnumSourceExclude(PurchaseStatus status) {

		log.debug(status);
	}
}