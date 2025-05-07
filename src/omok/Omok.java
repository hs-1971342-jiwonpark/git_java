package omok;

import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Omok {
	public static void main(String[] args) {
		Player user = new Player("사용자", "O");
		Player computer = new Player("컴퓨터", "X");
		Board board = new Board(19);
		play(board, user, computer);
	}

	// 플레이
	private static void play(Board board, Player user, Player computer) {
		boolean isOmok = false;
		Player owner = user;
		while (!isOmok) {
			if (owner == user) {
				isOmok = userTurn(board, user);
				owner = computer;
			} else {
				isOmok = computerTurn(board, computer);
				owner = user;
			}
			board.print();
		}
	}

	// 사용자 턴
	static boolean userTurn(Board board, Player user) {
		StringTokenizer st;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("\n" + user.name + "> ");
			String input = sc.nextLine();
			st = new StringTokenizer(input, " ");
		}
		String col = st.nextToken(); // k
		String row = st.nextToken(); // 5
		if (board.setOmok(user, col, row)) {
			System.out.println("사용자가 이겼습니다.");
			return true;
		}
		return false;
	}

	// 컴퓨터 턴
	static boolean computerTurn(Board board, Player computer) {
		Random rd = new Random();
		String col = String.valueOf((char) (rd.nextInt(19) + 97)); // k
		String row = String.valueOf(rd.nextInt(19)); // 5
		System.out.println("\n" + computer.name + "> " +  col + " " + row);
		if (board.setOmok(computer, col, row)) {
			System.out.println("종료");
			return true;
		}
		return false;
	}

}
