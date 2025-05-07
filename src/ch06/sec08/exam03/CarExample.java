package ch06.sec08.exam03;

import java.util.Scanner;

public class CarExample {
	public static void main(String[] args) {
		Validate a = new Validate(new Scanner(System.in).nextLine());
		a.getValidType().printMsg();

	}

}
