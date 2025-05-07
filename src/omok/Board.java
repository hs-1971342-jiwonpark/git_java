package omok;

public class Board {
	int size;
	String[][] map;

	// 보드 초기화
	Board(int size) {
		this.size = size;
		map = new String[size][size];
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				map[row][col] = ".";
			}
		}
	}

	// 보드 현황 출력
	public void print() {
		for (int row = 0; row < size; row++) {
			printPosNum(row);
			for (int col = 0; col < size; col++) {
				System.out.print(" " + map[row][col]);
			}
			System.out.println();
		}
		printPosStr(size);
		System.out.println();
	}

	// 숫자 행 열 맞추기
	public void printPosNum(int i) {
		String v = " ";
		if (i < 10) {
			v = "  ";
		}
		System.out.print(v + i);
	}
	
	// 문자 행 열 맞추기
	public void printPosStr(int size) {
		System.out.print("    ");
		for (int i = 1; i <= size; i++) {
			System.out.print((char) (64 + i) + " ");
		}
	}

	// 오목 세팅 (데이터 업데이트)
	public boolean setOmok(Player owner, String col, String row) {
		int colIdx = col.charAt(0) - 97;
		int rowIdx = Integer.parseInt(row);
		return isOmok(colIdx, rowIdx, owner);
	}

	// 오목 달성 여부 검증
	private boolean isOmok(int colIdx, int rowIdx, Player owner) {
		map[rowIdx][colIdx] = owner.stone;
		if (confirmVerticalLine(colIdx, rowIdx, owner)
				|| confirmHorizontalLine(colIdx, rowIdx, owner)
				|| confirmCrossLine1(colIdx, rowIdx, owner)
				|| confirmCrossLine2(colIdx, rowIdx, owner)) {
			return true;
		}
		return false;
	}

	// 오른쪽 대각선 검증
	private boolean confirmCrossLine1(int col, int row, Player owner) {
		int count = 0;
		boolean isOmok = false;
		for (int i = -5; i <= 5; i++) {
			int di = row + i;
			int dj = col + i;
			if (di < 19 && di >= 0 && dj < 19 && dj >= 0 && map[di][dj] == owner.stone) {
				count++;
			}
		}
		
		if (count == 5) {
			isOmok = true;
		}
		return isOmok;
	}
	
	// 왼쪽 대각선 검증
	private boolean confirmCrossLine2(int col, int row, Player owner) {
		int count = 0;
		boolean isOmok = false;
		for (int i = -5; i <= 5; i++) {
			int di = row + i;
			int dj = col - i;
			if (di < 19 && di >= 0 && dj < 19 && dj >= 0 && map[di][dj] == owner.stone) {
				count++;
			}
		}
		if (count == 5) {
			isOmok = true;
		}
		return isOmok;
	}

	// 가로 검증
	private boolean confirmHorizontalLine(int col, int row, Player owner) {
		int count = 0;
		boolean isOmok = false;
		for (int i = -5; i <= 5; i++) {
			int dj = row + i;
			if (dj < 19 && dj >= 0 && map[dj][col] == owner.stone) {
				count++;
			}
		}
		if (count == 5) {
			isOmok = true;
		}
		return isOmok;
	}

	// 세로 검증
	private boolean confirmVerticalLine(int col, int row, Player owner) {
		int count = 0;
		boolean isOmok = false;
		for (int i = -5; i <= 5; i++) {
			int di = col + i;
			if (di < 19 && di >= 0 && map[row][di] == owner.stone) {
				count++;
			}
		}
		if (count == 5) {
			isOmok = true;
		}
		return isOmok;
	}
}