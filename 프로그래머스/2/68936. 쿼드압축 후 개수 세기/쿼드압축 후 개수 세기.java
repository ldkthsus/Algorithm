import java.io.*;
import java.util.*;

class Solution {
    public static int one, zero;
    public int[] solution(int[][] arr) {
        int n = arr.length;
        dfs(0, n, 0, n, arr);
        int [] answer = {zero, one};
        return answer;
    }
    public static void dfs(int startI, int endI, int startJ, int endJ, 
                           int [][] arr){
        boolean check = true;
        int num = arr[startI][startJ];
        naga : for(int i = startI; i < endI; i++){
            for(int j = startJ; j < endJ; j++){
                if(num != arr[i][j]){
                    check = false;
                    break naga;
                }
            }
        }
        if(!check){
            dfs(startI, (endI + startI) / 2, startJ, (endJ + startJ) / 2, arr); //1
            dfs(startI, (endI + startI) / 2, (endJ + startJ) / 2, endJ, arr); //2
            dfs((endI + startI) / 2, endI, startJ, (endJ + startJ) / 2, arr); //3
            dfs((endI + startI) / 2, endI, (endJ + startJ) / 2, endJ, arr); //4
        }
        else {
            if(num == 0)
                zero++;
            else one++;
        }
    }
}