import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int time = 0;
        int now = health;
        int idx = 0;
        int cnt = 0;
        while(true){
            if(idx == attacks.length)
                break;
            
            if(time == attacks[idx][0]){
                now -= attacks[idx][1];
                if(now <= 0)
                    break;
                idx++;
                cnt = 0;
            } else{
                now += bandage[1];
                cnt++;
                if(cnt == bandage[0]) {
                    now += bandage[2];
                    cnt = 0;
                }
                if(now > health)
                    now = health;
            }
            time++;
        }
        
        if(now <= 0)
            answer = -1;
        else answer = now;
        
        return answer;
    }
}