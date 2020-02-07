package sampleobjects;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import enums.PurchaseStatus;

public class PurchaseProvider {

	public Purchase getFinalStatePurchase() {

		return new Purchase(1L, PurchaseStatus.COMPLETED, BigDecimal.ONE);
	}

	public List<Purchase> getListOfNotFailedPurchase() {

		final List<Purchase> result = new ArrayList<>();

		for (int i = 0; i < 5; i++) {

			PurchaseStatus status;
			do {
				status = PurchaseStatus.values()[new Random().nextInt(PurchaseStatus.values().length)];
			} while (PurchaseStatus.FAILED == status);

			result.add(new Purchase(1L, status, BigDecimal.ONE));
		}

		return result;
	}
}
