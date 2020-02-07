package sampleobjects;

import java.math.BigDecimal;

import enums.PurchaseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Purchase {

	private final long id;
	private final PurchaseStatus status;
	private BigDecimal amount;

	public boolean isFinalState() {
		return PurchaseStatus.FAILED == this.status
				|| PurchaseStatus.COMPLETED == this.status
				|| PurchaseStatus.EXPIRED == this.status;
	}
}
