package ch12.sec05;

public class StringEx {
	public static void main(String args[]) {
		// indexOf (해당 키워드의 첫 번째 위치)
		String greet = "안녕하세요";
		System.out.println(greet.indexOf("하")); // 2

		// 단어의 포함 여부 (없으면 -1, 있으면 0이상)
		if (greet.indexOf(".") > -1) // 매개변수가 문자열에 있는지
		
		// 문자열 자르기
		System.out.println(greet.substring(1)); // 녕하세요
		System.out.println(greet.substring(1,3)); // 녕하

		// 동적으로 어떤 값부터 잘라내야하는 구조
		System.out.println(greet.substring(greet.indexOf("하"))); // 하세요

		// 대소문자 변경
		String test = "ABC";
		System.out.println(test.toUpperCase());
		System.out.println(test.toLowerCase());

		// 공백 제거
		String test2 = "                    a bc                       ";
		System.out.println(test2.trim()); // 중간 공백은 제거하지 못함
		System.out.println(test2.replace(" ", "")); // 모든 공백 제거

		// 특정 문자열로 시작하는지 여부
		String test3 = "Mr.Lee";
		System.out.println(test3.startsWith("Mr")); // true
		System.out.println(test3.endsWith("Lee")); // true

		// 문자열로 변환
		int a = 1;
		String s1 = a + "";
		String s2 = String.valueOf(a);
		
		// 퀴즈
		String fileName = "2025.04.10_시간표.xlsx";
		// 파일명을 변경 System.currentTimeMillis _> 17.....xlsx
		String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
		System.out.println(newFileName);
		
	}

}
