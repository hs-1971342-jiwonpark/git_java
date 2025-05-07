package ch06.solution;

import java.util.Scanner;

public class BankApplication {
	Scanner sc = new Scanner(System.in);
	private static Account[] accounts = new Account[100];
	
	public void run() {
		while(true) {
			System.out.println("1.계좌생성 |2.계좌목록 |3.예금 ");
		}
	}
	
	public static Account[] getInstance() {
		for(int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account();
		}
		
		return accounts;
	}
	
}
