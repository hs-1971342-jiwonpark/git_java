package cd;

import java.util.*;

class Solution {
    
    static int[] arr;
    
    public int[] solution(int n) {
        if(n%2 == 0){
            arr = new int[n/2];
        }else{
            arr = new int[n/2 + 1];
        }
        createArr(arr,n);
        return arr;
    }
    
    public static void createArr(int[] arr, int n){
        int idx = 0;
        for(int i = 1; i<=n; i++){
            if(i % 2 == 1){
                arr[idx++] = i;
            }
        }
    }
}
