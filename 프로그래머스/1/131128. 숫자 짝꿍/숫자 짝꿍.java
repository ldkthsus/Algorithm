import java.io.*;
import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int xArr[] = new int[10];
        int yArr[] = new int[10];
        
        for(int i = 0; i < X.length(); i++){
            int val = X.charAt(i) - '0';
            xArr[val]++;
        }
        for(int i = 0; i < Y.length(); i++){
            int val = Y.charAt(i) - '0';
            yArr[val]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--){
            if(xArr[i] > 0 && yArr[i] > 0){
                int min = Math.min(xArr[i], yArr[i]);
                for(int j = 0; j < min; j++){
                    sb.append(i);
                }
            }
        }
        if(sb.length() == 0)
            return "-1";
        else{
            answer = sb.toString();
            if(answer.startsWith("0"))
                return "0";
            else return answer;
        }
    }
}