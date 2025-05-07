package account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Validate {

	// 유효한 숫자
	private int validNum;

	// 유효성 종류 판별
	private ValidType isValid = ValidType.CORRECT;

	// 유효한 숫자 검증
	Validate(String num) {
		isNumberValid(num);
		isZeroValid();
		isMinusValid();
	}

	// 숫자의 유효한 범위 검증
	Validate(String num, int start, int end) {
		this(num);
		isBoundaryValid(start, end);
	}

	// 숫자가 아닐 경우 예외 처리
	private void isNumberValid(String num) {
		try {
			this.validNum = Integer.parseInt(num);
		} catch (NumberFormatException e) {
			isValid = ValidType.NUMBER_FORMAT_EXCEPTION;
		}
	}

	// 0이 입력된 경우 예외 처리
	private void isZeroValid() {
		if (isValid != ValidType.CORRECT) {
			return;
		}

		if (validNum == 0) {
			isValid = ValidType.IS_ZERO_EXCEPTION;
		}
	}

	// 음수가 입력된 경우 예외 처리
	private void isMinusValid() {
		if (isValid != ValidType.CORRECT) {
			return;
		}

		if (validNum < 0) {
			isValid = ValidType.MINUS_EXCEPTION;
		}
	}

	// 유효한 범위를 초과할 경우 예외 처리
	private void isBoundaryValid(int start, int end) {
		if (isValid != ValidType.CORRECT) {
			return;
		}

		if (validNum < start || validNum > end) {
			isValid = ValidType.BOUNDARY_EXCEPTION;
		}
	}

	// 예외 목록을 정의한 열거형 클래스
	public enum ValidType {

		// 예외 목록
		NUMBER_FORMAT_EXCEPTION("숫자만 입력 가능합니다."),
		BOUNDARY_EXCEPTION("유효한 숫자의 범위를 벗어났습니다."),
		MINUS_EXCEPTION("음수값은 입력할 수 없습니다."),
		IS_ZERO_EXCEPTION("0은 입력하실 수 없습니다."),
		CORRECT("");

		// 에러 메세지 필드
		private final String ERROR_MESSAGE;

		// 에러 메세지 생성자
		ValidType(String s) {
			this.ERROR_MESSAGE = s;
		}

		// 에러 메세지 보여주기
		public void printMsg() {
			System.out.println(ERROR_MESSAGE);
		}

	}
}
