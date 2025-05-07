package ch07.sec02;

public class SmartPhoneExample {
	public static void main(String[] args) {
		SmartPhone myPhone = new SmartPhone("갤럭시","은색");
		
		System.out.println("모델: " + myPhone.model);
		System.out.println("색상: " + myPhone.color);
		System.out.println("와이파이 상태: " + myPhone.wifi);
		
		myPhone.bell();
		myPhone.sendVoice("여보세요.");
		myPhone.receiveVoice("안녕하세요! 저는 홍길동인데요.");
		myPhone.sendVoice("아~ 네, 반갑습니다.");
		myPhone.receiveVoice("저도요");
		myPhone.sendVoice("무슨 일이시죠?");
		
		Phone myPhone2 = new SmartPhone("아이폰","검정");
//		myPhone2.internet(); // 사용 불가
		
		// 강제 형 변환 (원래 자식 타입이 부모 타입으로 형 변환된 경우만 가능)
		SmartPhone myPhone3 = (SmartPhone) myPhone2;
		myPhone3.internet(); // 사용 가능

	}
}
