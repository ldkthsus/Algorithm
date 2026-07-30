import java.io.*;
import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        Map<String, Integer> word = new HashMap<>();
        String mes[] = message.split(" ");
        for(int i = 0; i < mes.length; i++){
            if(!word.containsKey(mes[i]))
                word.put(mes[i], 1);
            else word.put(mes[i], word.get(mes[i]) + 1);
        }
        
        Map<Integer, Integer> spo = new HashMap<>();
        for(int i = 0; i < spoiler_ranges.length; i++){
            int start = spoiler_ranges[i][0];
            int end = spoiler_ranges[i][1];
            
            for(int j = start; j <= end; j++){
                spo.put(j, 0);
            }
        }
       
        Set<String> set = new HashSet<>();
        boolean isSelected[] = new boolean[message.length()];
        Map<String, Integer> yes = new HashMap<>();
        Map<String, Integer> no = new HashMap<>();
        for(int i = 0; i < message.length(); i++){
            if(spo.containsKey(i) && message.charAt(i) != ' ' && !isSelected[i]){
                int start = i;
                while(true){
                    if(start == -1 || message.charAt(start) == ' ')
                        break;
                    start--;
                }
                int end = i;
                while(true){
                    if(end == message.length() || message.charAt(end) == ' ')
                        break;
                    end++;
                }
                for(int j = start + 1; j < end; j++){
                    isSelected[j] = true;
                }
                StringBuilder sb = new StringBuilder();
                for(int j = start + 1; j < end; j++){
                    sb.append(message.charAt(j));
                }
                if(!yes.containsKey(sb.toString()))
                    yes.put(sb.toString(), 1);
                else yes.put(sb.toString(), yes.get(sb.toString()) + 1);
            }
        }
        
        for(String key : word.keySet()){
            if(!yes.containsKey(key)){
                no.put(key, word.get(key));
            } //스포 방지 단어 안됨 
            else {
                int original = word.get(key);
                int spoiler = yes.get(key);
                
                no.put(key, original - spoiler);
            }
        }
        
        for(String key : yes.keySet()){
            if(!no.containsKey(key) || no.get(key) == 0){
                set.add(key);
            }
        }
        answer = set.size();
        return answer;
    }
}