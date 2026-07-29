import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Map<String, Integer> one = new HashMap<>();
        Map<String, Integer> two = new HashMap<>();
        int oneIdx = 0;
        int twoIdx = 0;
        
        for(int i = 0; i < cards1.length; i++){
            one.put(cards1[i], i);
        }
        for(int i = 0; i < cards2.length; i++){
            two.put(cards2[i], i);
        }
        for(int i = 0; i < goal.length; i++){
            String str = goal[i];
            if(one.containsKey(str)){
                if(oneIdx == one.get(str)){
                    oneIdx++;
                } else {
                    return "No";
                }
            } else {
                if(twoIdx == two.get(str)){
                    twoIdx++;
                } else {
                    return "No";
                }
            }
        }
        return "Yes";
    }
}