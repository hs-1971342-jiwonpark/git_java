package ch06.solution;

public class Solution {
	public static void main(String args[]) {
		solution(2000);
	}
	
	public static int solution(int price) {
        int answer = 0;
        
        if(price >= 100000 && price < 300000){
            answer = (int) (price - (price * 0.05));
        }
        else if(price >= 300000 && price < 500000){
            answer = (int) (price - (price * 0.1));
        }
        else if(price >= 500000){
            answer = (int) (price - (price * 0.2));
        }
        else {
        	answer = price;
        }
        return answer;
    }
	
}
