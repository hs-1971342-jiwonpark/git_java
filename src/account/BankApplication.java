package account;

import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {
	static Scanner sc = new Scanner(System.in);
	private static ArrayList<Account> accounts = new ArrayList<>();

	// 앱 시작
	public void run() {
		while (true) {
			System.out.println("----------------------------------------");
			System.out.println("1.계좌생성 |2.계좌목록 |3.예금 |4.출금|5. 종료");
			System.out.println("----------------------------------------");
			System.out.println("선택> ");

			// 입력 값 유효성 검증
			Validate vInput = new Validate(sc.nextLine(), 1, 5);
			if (isValidNumber(vInput))
				continue;

			int select = vInput.getValidNum();
			if (select == 1) {
				createAccount();
			} else if (select == 2) {
				printAccounts();
			} else if (select == 3) {
				depositMoney();
			} else if (select == 4) {
				withdrawMoney();
			} else if (select == 5) {
				System.out.println("종료");
				break;
			}
		}
	}

	// 계좌 생성
	private void createAccount() {
		printSelectMenu("계좌 생성");

		// 계좌 번호 입력
		String accountNum = "";
		do {
			System.out.println("계좌번호: ");
			accountNum = sc.nextLine();
		} while (!isDuplicatedAccountNumber(accountNum));

		// 계좌주 입력
		System.out.println("계좌주: ");
		String accountOwner = sc.nextLine();

		// 초기입금액 입력
		int initMoney = 0;
		while (true) {
			System.out.println("초기입금액: ");
			Validate vInput = new Validate(sc.nextLine());
			// 입력 값 유효성 검증
			if (isValidNumber(vInput))
				continue;
			initMoney = vInput.getValidNum();
			break;
		}

		Account account = new Account(accountOwner, accountOwner, initMoney);
		System.out.println("계좌 생성 완료");
		accounts.add(account);
	}

	// 계좌 조회
	private void printAccounts() {
		printSelectMenu("계좌목록");
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < accounts.size(); i++) {
			sb.append(accounts.get(i).getAccountNum()).append(" ").append(accounts.get(i).getAccountOwner()).append(" ")
					.append(accounts.get(i).getInitMoney()).append("\n");
		}

		System.out.println(sb);
	}

	// 예금
	private void depositMoney() {
		printSelectMenu("예금");

		System.out.println("계좌번호: ");
		Account selectAccount = findAccount(sc.nextLine());

		if (selectAccount == null) {
			System.out.println("계좌가 존재하지 않습니다.");
			return;
		}

		System.out.println("예금액: ");
		Validate vInput = new Validate(sc.nextLine());
		if (isValidNumber(vInput))
			return;

		int depositMoney = vInput.getValidNum();
		selectAccount.setInitMoney(selectAccount.getInitMoney() + depositMoney);
		System.out.println("예금 성공");
	}

	// 출금
	private void withdrawMoney() {
		printSelectMenu("출금");

		System.out.println("계좌번호: ");
		Account selectAccount = findAccount(sc.nextLine());

		if (selectAccount == null) {
			System.out.println("계좌가 존재하지 않습니다.");
			return;
		}

		System.out.println("출금액: ");
		Validate vInput = new Validate(sc.nextLine());
		if (isValidNumber(vInput))
			return;

		int withdrawMoney = vInput.getValidNum();

		if (selectAccount.getInitMoney() < withdrawMoney) {
			System.out.println("금액 부족");
			return;
		}
		selectAccount.setInitMoney(selectAccount.getInitMoney() - withdrawMoney);
		System.out.println("출금 성공");
	}

	// 선택 구문 출력 함수
	private void printSelectMenu(String msg) {
		System.out.println("----------");
		System.out.println(msg);
		System.out.println("----------");
	}

	// 정수값 판별 함수
	private boolean isValidNumber(Validate vInput) {
		if (vInput.getIsValid() == Validate.ValidType.CORRECT) {
			return false;
		}
		vInput.getIsValid().printMsg();
		return true;
	}

	// 계좌를 찾는 함수
	private Account findAccount(String inputAccountNum) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNum().equals(inputAccountNum)) {
				return accounts.get(i);
			}
		}
		return null;
	}

	// 계좌 중복 여부 판별 함수
	private boolean isDuplicatedAccountNumber(String input) {
		for (Account ac : accounts) {
			if (ac != null && ac.getAccountNum().equals(input)) {
				System.out.println("이미 존재하는 계좌입니다.");
				return false;
			}
		}
		return true;
	}

}