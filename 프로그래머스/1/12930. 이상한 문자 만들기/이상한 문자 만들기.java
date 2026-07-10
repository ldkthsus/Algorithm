import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        for(int i = 0; i < s.length(); i++){
            if(!Character.isAlphabetic(s.charAt(i)))
                answer += " ";
            else {
                int idx = 0;
                char now;
                while(true){
                    if(i + idx == s.length())
                        break;
                    if(!Character.isAlphabetic(s.charAt(i + idx)))
                        break;
                    
                    if(idx % 2 == 0){
                        now = Character.toUpperCase(s.charAt(i + idx));
                    } else {
                        now = Character.toLowerCase(s.charAt(i + idx));
                    }
                    answer += now;
                    idx++;
                }
                i = i + idx - 1;
            }
        }
        return answer;
    }
}