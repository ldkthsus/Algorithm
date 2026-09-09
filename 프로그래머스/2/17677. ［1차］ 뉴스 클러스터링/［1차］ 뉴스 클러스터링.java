import java.io.*;
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        Map<String, Integer> a = new HashMap<>();
        Map<String, Integer> b = new HashMap<>();
        
        for(int i = 0; i < str1.length() - 1; i++){
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i + 1);
            if(!Character.isAlphabetic(ch1) || !Character.isAlphabetic(ch2))
                continue;
            StringBuilder sb = new StringBuilder();
            sb.append(Character.toUpperCase(ch1))
                .append(Character.toUpperCase(ch2));
            if(!a.containsKey(sb.toString())){
                a.put(sb.toString(), 1);
            } else {
                a.put(sb.toString(), a.get(sb.toString()) + 1);
            }
        }
        
        for(int i = 0; i < str2.length() - 1; i++){
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i + 1);
            if(!Character.isAlphabetic(ch1) || !Character.isAlphabetic(ch2))
                continue;
            StringBuilder sb = new StringBuilder();
            sb.append(Character.toUpperCase(ch1))
                .append(Character.toUpperCase(ch2));
            if(!b.containsKey(sb.toString())){
                b.put(sb.toString(), 1);
            } else {
                b.put(sb.toString(), b.get(sb.toString()) + 1);
            }
        }
        int total = 0; //합집합
        int cnt = 0; //교집합
        for(String key : a.keySet()){
            if(b.containsKey(key)){
                cnt += Math.min(a.get(key), b.get(key));
                total += Math.max(a.get(key), b.get(key));
            } else {
                total += a.get(key);
            }
        }
        for(String key : b.keySet()){
            if(!a.containsKey(key)){
                total += b.get(key);
            }
        }
        double result = 0;
        if(total == 0)
            result = 65536;
        else
            result = (double) cnt / total * 65536;
        answer = (int) result;
        return answer;
    }
}