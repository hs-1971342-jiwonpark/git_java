package ch12.sec03.exam01;

public class EqualsExample {

	public static void main(String[] args) {
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		Member obj3 = new Member("red");

		if (obj1.equals(obj2)) {
			System.out.println("obj1과 obj2는 동등합니다.");
		} else {
			System.out.println("obj1과 obj2는 동등하지 않습니다.");
		}

		if (obj1.equals(obj3)) {
			System.out.println("obj1과 obj3는 동등합니다.");
		} else {
			System.out.println("obj1과 obj3는 동등하지 않습니다.");
		}
		
		System.out.println();
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		System.out.println(obj3.toString());
		
		System.out.println();
		System.out.println(obj1.getId());
		System.out.println(obj2.getId());
		System.out.println(obj3.getId());
		
		obj1.setId("yellow");
		obj2.setId("green");
		obj3.setId("sky");
		
		System.out.println();
		System.out.println(obj1.getId());
		System.out.println(obj2.getId());
		System.out.println(obj3.getId());
	}

}
