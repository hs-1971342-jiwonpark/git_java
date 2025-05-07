package ch04;

import java.util.Arrays;
import java.util.Collections;

public class ch04 {

    public static void main(String[] args) {
		
		Rank rk = Rank.FIVE;
		
		System.out.println(rk.toString());
	}
    public enum Rank {
    	THREE(3, 4_000),
    	FOUR(4, 10_000),
    	FIVE(5, 30_000);
    
    	
    	private final int match;
    	private final int money;
    	private int count;
    	
    	Rank(int match, int money) {
    		this.match = match;
    		this.money = money;
    	}
    
    	public void plusCount() {
    		this.count++;
    	}
    }
}