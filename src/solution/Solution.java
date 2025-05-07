package solution;

class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder sb = new StringBuilder();
        sb.append(my_string);
        return sb.replace(num1,num1+1, my_string.charAt(num2)+"").replace(num2,num2+1,my_string.charAt(num1)+"").toString();
    }
}