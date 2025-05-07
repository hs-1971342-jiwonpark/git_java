package ch12.sec10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternExample {
	public static void main(String args[]) {
		String regExp = "(02|010)-\\d{3,4}-\\d{4}";
		String data = "010-123-4567";
		
		boolean result = Pattern.matches(regExp, data);
		
		if(result) {
			System.out.println("정규식과 일치합니다.");
		}
		else {
			System.out.println("정규식과 일치하지 않습니다.");
		}
		
		regExp = "\\w+@\\w+\\. \\w+(\\. \\w+)?";
		data = "angel@mycompanycon";
		result = Pattern.matches(regExp, data);
		
		if(result) {
			System.out.println("정규식과 일치합니다.");
		}
		else {
			System.out.println("정규식과 일치하지 않습니다.");
		}
		
		// 컴파일
		// 속도가 빨라짐
		Pattern p = Pattern.compile("b[a-z]*"); // b로 시작하고, 영문 소문자 0개 이상
		Matcher m = p.matcher("ball");
		System.out.println(m.matches());
		System.out.println(p.matcher("batman").matches());
		
		String source = "122 안녕하세요 저는 홍길동입니다. 어떻고 저떻고 제 전화번호는 010-1234-5678입니다. 제 친구 번호는 010-2222-3333입니다.";
		// 미리 컴파일
		p = Pattern.compile("(0\\d{1,2})-(\\d{3,4})-(\\d{4})"); // ( )는 그룹핑 (통째로, 개별로 찾아낼 수 있음)
		m = p.matcher(source);
		while(m.find()) { // 찾으면 true
			System.out.println("찾음");
			System.out.println(m.group());
			System.out.println(m.group(1) + "은 1번그룹");
			System.out.println(m.group(2) + "은 2번그룹");
			System.out.println(m.group(3) + "은 3번그룹");
			System.out.println();
		}
		
	}
	
}
