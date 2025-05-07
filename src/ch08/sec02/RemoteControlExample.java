package ch08.sec02;

import ch07.sec10.exam02.Animal;

public class RemoteControlExample {

	public static void main(String[] args) {
		// 익명 구현 객체
		// implements를 구현한 구현체는 이름이 없음
		// 주로 1회용에 사용 (일회성)
		RemoteControl rc = new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("에어컨을 켭니다.");
			}
		}; // 실행문 이므로, 세미콜론
		
		rc.turnOn();
		
		// 익명 상속 객체
		Animal ani = new Animal() {
			@Override
			public void sound() {
				System.out.println("어흥");
			}
		};
		
		ani.sound();
	}
}
