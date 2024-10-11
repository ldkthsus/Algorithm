import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 1;
        char word = s.charAt(0);
        int sameCnt = 0;
        int diffCnt = 0;
        
        for(int i=0;i<s.length()-1;i++){
            if(word == s.charAt(i)){
                sameCnt+=1;
            }
            else{
                diffCnt +=1;
            }
            if(sameCnt == diffCnt){
                word = s.charAt(i+1);
                answer +=1;
                sameCnt = 0;
                diffCnt = 0;
            }
        }
        return answer;
    }
}