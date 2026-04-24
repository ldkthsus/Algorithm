import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int answer[] = new int[2];
        int sero = 0;
        int garo = 0;
        for(int i = 1; i <= yellow; i++){
            if(yellow % i == 0){
                int se = i;
                int ga = yellow / i;
                
                sero = (se + 2) * 2;
                garo = ga * 2;
                
                if(sero + garo == brown){
                    sero = se + 2;
                    garo = ga + 2;
                    if(garo >= sero){
                        answer[0] = garo;
                        answer[1] = sero;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}