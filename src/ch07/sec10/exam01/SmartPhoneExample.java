package ch07.sec10.exam01;

public class SmartPhoneExample {
	public static void main(String[] args) {
		//Phone phone = new phone(); //
		
		SmartPhone smartPhone = new SmartPhone("홍길동");
		
		smartPhone.turnOn();
		smartPhone.internetSearch(); // 에러, 자동 형 변환 필요
		smartPhone.turnOff();
		
		Phone phone = new SmartPhone("홍길동");
		phone.turnOn();
//		phone.internetSearch(); // 에러, 자동 형 변환 필요
		phone.turnOff();
		
	}
}
