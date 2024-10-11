import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tSize = t.length();
        int pSize = p.length();
        BigInteger bigT = new BigInteger(t);
        Long longP = Long.parseLong(p);
        
        for(int i=0;i<tSize;i++){
            if(i+pSize > tSize){
                break;
            }
            Long num = Long.parseLong(t.substring(i, i+(pSize)));
            if(num <= longP){
                answer +=1;
            }
        }
        return answer;
    }
}