package ch06.sec15;

public class Singleton {
	private static Singleton singleton = new Singleton(); // 싱글톤 객체가 저장되어 있는 메모리의 주소값
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		return singleton; // 주소값 리턴
	}
}
