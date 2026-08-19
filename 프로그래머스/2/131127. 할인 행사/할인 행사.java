import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> order = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            order.put(want[i], number[i]);
        }
        
        Map<String, Integer> mart = new HashMap<>();
        for(int i = 0; i < 10; i++){
            if(mart.containsKey(discount[i])){
                mart.put(discount[i], mart.get(discount[i]) + 1);
            } else {
                mart.put(discount[i], 1);
            }
        }
            int start = 0;
            int end = 9;
            while(true){
                boolean check = true;
                for(String key : order.keySet()){
                    if(!mart.containsKey(key)){
                        check = false;
                        break;
                    } else {
                        int value = order.get(key);
                        if(value > mart.get(key)){
                            check = false;
                            break;
                        }
                    }
                }
                if(check) {
                    answer++;
                }
                String menu = discount[start];
                int val = mart.get(menu);
                if(val == 1)
                    mart.remove(menu);
                else mart.put(menu, mart.get(menu) - 1);
                
                start++;
                end++;
                if(end == discount.length)
                    break;
                menu = discount[end];
                if(mart.containsKey(menu)){
                    mart.put(menu, mart.get(menu) + 1);
                } else mart.put(menu, 1);
            }
        return answer;
    }
}