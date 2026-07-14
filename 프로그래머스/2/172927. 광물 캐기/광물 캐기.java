import java.io.*;
import java.util.*;

class Solution {
    public static int arr[][] = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    public static int order[], n, answer;
    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        for(int i = 0; i < picks.length; i++){
            n += picks[i];
        }
        order = new int[n];
        perm(0, picks, minerals);
        return answer;
    }
    public static void perm(int depth, int[] picks, String[] minerals){
        if(depth == n){
            int idx = 0;
            int mIdx = 0;
            int result = 0;
            naga : while(true){
                if(idx == order.length || mIdx == minerals.length)
                    break naga;
                
                for(int i = 0; i < 5; i++){
                    int val = 0;
                    
                    if(mIdx + i == minerals.length)
                        break naga;
                    
                    if(minerals[mIdx + i].equals("diamond"))
                        val = 0;
                    else if(minerals[mIdx + i].equals("iron"))
                        val = 1;
                    else val = 2;
                    
                    result += arr[order[idx]][val];
                }
                idx++;
                mIdx += 5;
            }
            answer = Math.min(answer, result);
            return;
        }
        for(int i = 0; i < 3; i++){
            if(picks[i] > 0){
                picks[i]--;
                order[depth] = i;
                perm(depth + 1, picks, minerals);
                picks[i]++;
            }
        }
    }    
}