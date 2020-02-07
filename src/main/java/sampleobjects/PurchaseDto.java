package sampleobjects;

import java.math.BigDecimal;

import enums.PurchaseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PurchaseDto {

	private final long id;
	private final PurchaseStatus status;
	private BigDecimal amount;
	private Transaction transaction;
}
