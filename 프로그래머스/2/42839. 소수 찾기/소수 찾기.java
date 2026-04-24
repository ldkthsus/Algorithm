import java.io.*;
import java.util.*;

class Solution {
    public static int n, arr[], result[];
    public static boolean isSelected[];
    public static Set<Integer> set;
    public int solution(String numbers) {
        int answer = 0;
        n = numbers.length();
        arr = new int [n];
        for(int i = 0; i < n; i++){
            arr[i] = numbers.charAt(i) - '0';
        }
       isSelected = new boolean[n];
        set = new HashSet<>();
        result = new int[n];
        dfs(0);
        answer = set.size();
        return answer;
    }
    public static void dfs(int idx){
        if(idx > 0){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < idx; i++){
                sb.append(result[i]);
            }
            int number = Integer.parseInt(sb.toString());
            if(sosu(number))
                set.add(number);
        }
        if(idx == n)
            return;
        for(int i = 0; i < n; i++){
            if(!isSelected[i]){
                result[idx] = arr[i];
                isSelected[i] = true;
                dfs(idx + 1);
                isSelected[i] = false;
            }
        }
    }
    public static boolean sosu(int num){
        if(num < 2)
            return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
             return false;  
            }
        }
        return true;  
    } 
}