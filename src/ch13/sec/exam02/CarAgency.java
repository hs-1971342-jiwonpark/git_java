package ch13.sec.exam02;

public class CarAgency implements Rentable<Car>{

	@Override
	public Car rent() {
		return new Car();
	}
}
