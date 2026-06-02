import java.io.*;
import java.util.*;

class Solution {
    public static boolean visited[];
    public static int cnt = 0;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(computers, i, n);
                cnt++;
            }
        }
        answer = cnt;
        return answer;
    }
    public static void dfs(int [][]com, int idx, int n){
        visited[idx] = true;
        for(int i = 0; i < n; i++){
            if(com[idx][i] == 1 && !visited[i]){
                dfs(com, i, n);
            }
        }
    }
}