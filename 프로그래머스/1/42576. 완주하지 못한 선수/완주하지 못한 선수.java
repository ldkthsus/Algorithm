import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> par = new HashMap<>();
        Map<String, Integer> com = new HashMap<>();
        for(int i = 0; i < participant.length; i++){
            if(!par.containsKey(participant[i])){
                par.put(participant[i], 1);
            } else par.put(participant[i], par.get(participant[i]) + 1);
        }
        for(int i = 0; i < completion.length; i++){
            if(!com.containsKey(completion[i])){
                com.put(completion[i], 1);
            } else com.put(completion[i], com.get(completion[i]) + 1);
        }
         String answer = "";
        for(String key : par.keySet()){
            if(com.containsKey(key)){
                int val = com.get(key);
                int start = par.get(key);
                
                if(val != start){
                    answer = key;
                    break;
                }
            } else{
                answer = key;
                break;
            }
        }
        return answer;
    }
}