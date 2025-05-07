package ch07.sec04.exam01;

public class ComputerExample {
	public static void main(String args[]) {
		Calculator calculator = new Calculator();
		int r = 10;
		
		System.out.println("원 면적: " + calculator.areaCircle(r));
		System.out.println();
		
		Computer computer = new Computer();
		System.out.println("원 면적: " + computer.areaCircle(r));
		System.out.println();
		
		Calculator car = computer;
		System.out.println("원 면적: " + car.areaCircle(r)); // 부모의 메서드가 실행 -> 실제 자식 메서드가 실행
		System.out.println();
//		car.game() // 사용 불가
	}
}
