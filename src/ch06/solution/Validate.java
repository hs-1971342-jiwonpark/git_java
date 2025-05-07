package ch06.solution;

// 입력 숫자 유효성 검증 클래스
public class Validate {
	
	// 유효한 숫자
	private int validNum;
	
	// 유효성 종류 판별
	private ValidType isValid = ValidType.CORRECT;
	
	// 숫자 가저오기
	public int getValidNum() {
		return validNum;
	}
	
	// 예외 여부 가저오기
	public ValidType getValidType() {
		return isValid;
	}
	
	// 예외 여부 값 세팅
	public void setIsValid(ValidType isValid) {
		this.isValid = isValid;
	}
	
	// 숫자 세팅
	public void setNum(int validNum) {
		this.validNum = validNum;
	}
	
	// 유효한 숫자 검증
	Validate(String num){
		isNumberValid(num);
	}
	
	// 숫자의 유효한 범위 검증
	Validate(String num, int start, int end){
		this(num);
		isBoundaryValid(start, end);
	}
	
	// 숫자가 아닐 경우 예외 처리
	private void isNumberValid(String num) {
		try {
			this.validNum = Integer.parseInt(num);
		} catch (NumberFormatException e) {
			isValid = ValidType.NUMBERFORMAT_EXCEPTION;
		}
	}
	
	// 유효한 범위를 초과할 경우 예외 처리
	private void isBoundaryValid(int start, int end) {
		if(isValid != ValidType.NUMBERFORMAT_EXCEPTION && validNum >= start && validNum <= end) {
			isValid = ValidType.CORRECT;
			return;
		}
		isValid = ValidType.BOUNDARY_EXCEPTION;
	}
	
	// 예외 목록을 정의한 열거형 클래스
	public enum ValidType {
		
		//예외 목록
		NUMBERFORMAT_EXCEPTION("숫자만 입력 가능합니다."), 
		BOUNDARY_EXCEPTION("유효한 숫자의 범위를 벗어났습니다."), 
		CORRECT("성공");
		
		// 에러 메세지 필드
		private String errorMsg;
		
		// 에러 메세지 생성자
		ValidType(String s){
			this.errorMsg = s;
		}
		
		// 에러 메세지 보여주기
		public void printMsg() {
			System.out.println(errorMsg);
		}
		
	}
}
