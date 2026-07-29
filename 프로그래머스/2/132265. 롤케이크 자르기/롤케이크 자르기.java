import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> old = new HashMap<>();
        Map<Integer, Integer> young = new HashMap<>();
        for(int i = 0; i < topping.length; i++){
            int val = topping[i];
            if(!old.containsKey(val)){
                old.put(val, 1);
            } else {
                old.put(val, old.get(val) + 1);
            }
        }
        for(int i = 0; i < topping.length; i++){
            if(!young.containsKey(topping[i])){
                young.put(topping[i], 1);
            } else {
                young.put(topping[i], young.get(topping[i]) + 1);
            }
            int val = old.get(topping[i]);
            if(val == 1){
                old.remove(topping[i]);
            } else {
                old.put(topping[i], val - 1);
            }
            if(old.size() == young.size())
                answer++;
        }
        return answer;
    }
}