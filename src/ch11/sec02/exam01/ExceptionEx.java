package ch11.sec02.exam01;

public class ExceptionEx{
	public static void main(String[] args) {
		try {
			System.out.println("시작");
			int a = 3;
			int b = 0;
			int c = a / b; // 예외 발생
			System.out.println("끝");
		} catch (ArithmeticException e) {
			System.out.println(e);
		} finally {
			System.out.println("무조건 실행");
		}
	}

}
