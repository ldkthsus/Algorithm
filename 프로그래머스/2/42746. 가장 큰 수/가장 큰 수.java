import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        List<String> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++){
            list.add(String.valueOf(numbers[i]));
        }
        Collections.sort(list, new Comparator<String>(){
           @Override
            public int compare(String s1, String s2){
                String a = s1 + s2;
                String b = s2 + s1;
                
                return b.compareTo(a);
            }
        });
        for(int i = 0; i < list.size(); i++){
            answer += list.get(i);
        }
        
        if(answer.startsWith("0"))
           answer = "0";
        return answer;
    }
}