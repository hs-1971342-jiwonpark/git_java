package account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Account {
	// 계좌 번호
	private String accountNum;

	// 계좌주
	private String accountOwner;

	// 잔여 금액
	private int initMoney;

}