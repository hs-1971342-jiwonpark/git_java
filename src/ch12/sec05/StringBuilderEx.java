package ch12.sec05;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringBuilderEx {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String strNow2 = sdf2.format(now);
		System.out.println(strNow2);
	}

}
