import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        int arr[] = new int[babbling.length];
        Map<String, Integer> stan = new HashMap<>();
        stan.put("aya", 3);
        stan.put("ye", 2);
        stan.put("woo", 3);
        stan.put("ma", 2);
        
        for(int i = 0; i < babbling.length; i++){
            String now = babbling[i];
            for(String bab : stan.keySet()){
                if(now.contains(bab)){
                    arr[i] = arr[i] + stan.get(bab);
                }
            }
        }
        for(int i = 0; i < babbling.length; i++){
            if(babbling[i].length() == arr[i]){
                answer++;
            }
        }
        return answer;
    }
}