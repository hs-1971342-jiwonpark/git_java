package ch06.sec07.exam01;

public class Car {

	private String model;
	private String color;
	private int maxSpeed;

	public Car(String model) {
		this(model, "은색", 250);
	}

	Car(String model, String color) {
		this(model, color, 250);
	}

	Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
		System.out.println(this.model + ", " + this.color + ", " + this.maxSpeed);
	}

	@Override
	public String toString() {
		return "모델: " + model + "\n" + "색깔: " + color + "\n" + "스피드: " + maxSpeed;
	}

}
