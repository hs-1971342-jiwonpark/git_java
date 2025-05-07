package ch06.sec08.exam03;

public class Car {
	int gas;
	
	void setGas(int gas) {
		this.gas = gas;
	}

	boolean isLeftGas() {
		if (gas == 0) {
			System.out.println("gas가 없습니다");
			return false;
		}
		System.out.println("gas가 있습니다.");
		return true;
	}

	void run() {
		while (true) {
			if (gas <= 0) {
				System.out.println("멈춥니다.(gas잔량:" + gas + ")");
				return;
			}
			System.out.println("달립니다.(gas잔량:" + gas + ")");
			gas -= 1;
		}
	}
	
	// static 블록 (처음 1회만 실행)
	static {
		System.out.println("static 블록");
	}
	
	// instance 블록 (객체를 생성할 때마다 실행)
	{
		System.out.println("instance 블록");
	}
	

	
}


