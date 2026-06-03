import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < operations.length; i++){
            String op[] = operations[i].split(" ");
            
            if(op[0].equals("I")){
                int val = Integer.parseInt(op[1]);
                if(map.containsKey(val))
                    map.put(val, map.get(val) + 1);
                else map.put(val, 1);
            } else{
                if(Integer.parseInt(op[1]) == 1 && !map.isEmpty()){
                    int key = map.lastKey();
                    int result = map.get(key);
                    if(result - 1 == 0)
                        map.remove(key);
                    else map.put(key, result - 1);
                } else if(Integer.parseInt(op[1]) == -1 && !map.isEmpty()){
                    int key = map.firstKey();
                    int result = map.get(key);
                    if(result - 1 == 0)
                        map.remove(key);
                    else map.put(key, result - 1);
                }
            }
        }
        if(map.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        } else{
            answer[0] = map.lastKey();
            answer[1] = map.firstKey();
        }
        return answer;
    }
}