package ch06.sec04;

public class Student {
	
	String name = "홍길동"; // 필드
	
	Student(String n) {
		name = n;
		System.out.println(name);
	}


	public static void main(String[] args) {
		Student s1 = new Student("김길동");
		
		Student s2 = new Student("홍길동");
				
		Student s3 = s2; // 같은 주소
		
		System.out.println(s2 == s3); // true
		
		System.out.println(Math.round(3.5));
	}

}
