import java.io.*;
import java.util.*;

class Solution {
    public static int n, result[], max, power, games[][];
    public static boolean isSelected[];
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        n = dungeons.length;
        result = new int[n];
        isSelected = new boolean[n];
        max = Integer.MIN_VALUE;
        power = k;
        games = new int [n][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                games[i][j] = dungeons[i][j];
            }
        }
        perm(0);
        answer = max;
        return answer;
    }
    public static void perm(int idx){
        if(idx == n){
            int cnt = 0;
            int temp = power;
            for(int i = 0; i < n; i++){
                int val = result[i];
                if(games[val][0] > temp)
                    break;
                temp -= games[val][1];
                cnt++;
            }
            max = Math.max(cnt, max);
            return;
        }
        for(int i = 0 ; i < n; i++){
            if(!isSelected[i]){
                result[idx] = i;
                isSelected[i] = true;
                perm(idx + 1);
                isSelected[i] = false;
            }
        }
        
    }
}