package sampleobjects;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Transaction {

	private long id;
	private BigDecimal amount;
}
