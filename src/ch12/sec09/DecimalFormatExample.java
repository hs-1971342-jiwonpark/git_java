package ch12.sec09;

import java.text.DecimalFormat;

public class DecimalFormatExample {
	public static void main(String args[]) {
		
		double a = 123456789.127;
		
		DecimalFormat sdf = new DecimalFormat("#,###.####"); // 자릿수만큼 # (3자리 반올림)
		System.out.println(sdf.format(a));
		
		DecimalFormat sdf2 = new DecimalFormat("#,###.0000"); // 자릿수가 부족하면 채워줌 (0), #은 채워주지 않음
		System.out.println(sdf2.format(a));
	}
}
