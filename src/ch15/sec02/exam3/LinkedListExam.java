package ch15.sec02.exam3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExam {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		for(int i=0;i<10000;i++) {
			list1.add(0,String.valueOf(i));
		}
		endTime = System.nanoTime();
		long totalTime1 = endTime - startTime;
		System.out.printf("%-17s %8d ns \n", "ArrayList 걸린 시간: ",(endTime-startTime));
		
		startTime = System.nanoTime();
		for(int i=0;i<10000;i++) {
			list2.add(0,String.valueOf(i));
		}
		endTime = System.nanoTime();
		long totalTime2 = endTime - startTime;
		System.out.printf("%-17s %8d ns \n", "LinkedList 걸린 시간: ",(endTime-startTime));
	
		System.out.println("ArrayList가 " + totalTime1 / totalTime2 + "배 빠름");
		System.out.println();
		
		startTime = System.nanoTime();
		for(int i=0;i<10000;i++) {
			list1.get(i);
		}
		endTime = System.nanoTime();
		long totalTime3 = endTime - startTime;
		System.out.printf("%-17s %8d ns \n", "ArrayList 걸린 시간: ",(endTime-startTime));
		
		startTime = System.nanoTime();
		for(int i=0;i<10000;i++) {
			list2.get(i);
		}
		endTime = System.nanoTime();
		long totalTime4 = endTime - startTime;
		System.out.printf("%-17s %8d ns \n", "LinkedList 걸린 시간: ",(endTime-startTime));
	
		System.out.println("LinkedList가 " + totalTime4 / totalTime3 + "배 빠름");
	}
}
