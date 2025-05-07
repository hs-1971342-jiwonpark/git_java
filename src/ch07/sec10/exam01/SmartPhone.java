package ch07.sec10.exam01;

public class SmartPhone extends Phone {
	SmartPhone(String owner){
		super(owner); // 기본 생성자 매개 변수 써서 없으므로 만들어 주기
	}
	
	void internetSearch() {
		System.out.println("인터넷 검색을 합니다.");
	}
	
}
