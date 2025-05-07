package ch13.sec.exam01;

public class GenericExample {

	public static void main(String[] args) {
		Product<TV, String> product = new Product<>();
		product.setKind(new TV());
		product.setModel("스마트TV");
		
		TV tv = product.getKind();
		String tvModel = product.getModel();
		
		Product<Car, String> product2 = new Product<>();
		product2.setKind(new Car());
		product2.setModel("SUV 자동차");
		
		Car car = product2.getKind();
		String carModel = product2.getModel();
		
		System.out.println(tvModel);
		System.out.println(carModel);
	}

}
