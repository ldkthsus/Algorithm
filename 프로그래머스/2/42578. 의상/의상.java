import java.util.*;
import java.io.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        int size = clothes.length;
        for(int i=0;i<size;i++){
           if(!map.containsKey(clothes[i][1])){
               map.put(clothes[i][1], 1);
           }
            else{
                map.put(clothes[i][1], map.get(clothes[i][1])+1);
            }
        }
 
        for(String type : map.keySet()){
            answer *= (map.get(type)+1);
        }
        
        
        
        return answer-1;
    }
}