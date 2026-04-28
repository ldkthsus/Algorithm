import java.io.*;
import java.util.*;

class Solution {
    public static int n, min;
    public static boolean visited[];
    public static String end;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        n = words.length;
        visited = new boolean [n];
        end = target;
        min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            String str = words[i];
            int cnt = 0;
            for(int j = 0; j < str.length(); j++){
                if(begin.charAt(j) == str.charAt(j))
                    cnt++;
            }
            if(cnt == str.length() - 1){
                Arrays.fill(visited, false);
                dfs(i, words, 1);
            }
        }
        if(min == Integer.MAX_VALUE)
            min = 0;
        answer = min;
        return answer;
    }
    public static void dfs(int idx, String [] words, int cnt){
        visited[idx] = true;
        if(words[idx].equals(end)){
            min = Math.min(min, cnt);
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                String str = words[i];
                int count = 0;
                for(int j = 0; j < str.length(); j++){
                    if(words[idx].charAt(j) == str.charAt(j))
                        count++;
                }
                if(count == str.length() - 1){
                    dfs(i, words, cnt + 1);
                    visited[i] = false;
                }
            }
        }
    }
}