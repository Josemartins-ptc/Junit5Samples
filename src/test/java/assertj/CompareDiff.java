package assertj;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enums.PurchaseStatus;
import sampleobjects.Purchase;
import sampleobjects.PurchaseDto;
import sampleobjects.Transaction;

public class CompareDiff {

	Purchase purchase;
	Transaction transaction;

	@BeforeEach
	void init() {

		purchase = new Purchase(1L, PurchaseStatus.COMPLETED, BigDecimal.ONE);
		transaction = new Transaction(1L, purchase.getAmount());
	}

	@Test
	void compareDifferentObjects() {

		assertThat(transaction).isEqualToComparingOnlyGivenFields(purchase, "amount");

	}

	@Test
	void compareRecursive() {

		PurchaseDto purchaseDto = new PurchaseDto(1L, PurchaseStatus.COMPLETED, BigDecimal.ONE, transaction);

		assertThat(purchase)
				.usingRecursiveComparison()
				.isEqualTo(purchaseDto)
				.ignoringFields("transaction");
	}

}
