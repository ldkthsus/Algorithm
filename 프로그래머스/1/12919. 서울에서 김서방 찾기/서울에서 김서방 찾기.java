import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int ans = 0;
        for(int i = 0; i < seoul.length; i++){
            if(seoul[i].equals("Kim")){
                ans = i;
                break;
            }
        }
        answer = "김서방은 ";
        answer += String.valueOf(ans);
        answer += "에 있다";
        return answer;
    }
}