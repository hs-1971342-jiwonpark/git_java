package ch13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch06.sec07.exam01.Car;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class GenericEx {
	public static void main(String args[]) {
		// list 인터페이스
		// 배열과 유사 : 여러 값을 저장하는 용도
		// 타입제한 없음, 길이 변경 가능
		List<Order> list = new ArrayList();
		
		// 같은 객체
		Order o = new Order();
		
		o = new Order();
		o.setNumber("12345");
		list.add(o);
		o = new Order();
		o.setNumber("12346");
		list.add(o);
		o = new Order();
		o.setNumber("12347");
		list.add(o);
		
		for(int i =0; i< list.size(); i++) {
			System.out.println(((Order) list.get(i)).getNumber());
			System.out.println(list.get(i).getNumber());
		}
		
	}
}

@Getter
@Setter
@ToString
class Order{
	private String number;
	private String date;
	private int price;
}