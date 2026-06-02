import java.io.*;
import java.util.*;

class Solution {
    public static boolean visited[];
    public static int min;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        min = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            String wr = words[i];
            int cnt = 0;
            for(int j = 0; j < wr.length(); j++){
                char stan = begin.charAt(j);
                char now = wr.charAt(j);
                
                if(stan != now)
                    cnt++;
            }
            if(cnt == 1){
                Arrays.fill(visited, false);
                dfs(words, target, i, 1);
            }
        }
        if(min == Integer.MAX_VALUE)
            answer = 0;
        else answer = min;
        return answer;
    }
    public static void dfs(String []words, String target, int idx, int cnt){
        visited[idx] = true;
        if(words[idx].equals(target)){
            min = Math.min(cnt, min);
            return;
        }
        for(int i = 0; i < words.length; i++){
            if(visited[i])
                continue;
            String wr = words[i];
            int count = 0;
            
            for(int j = 0; j < wr.length(); j++){
                char stan = words[idx].charAt(j);
                char now = wr.charAt(j);
                
                if(stan != now){
                    count++;
                }
            }
            if(count == 1){
                dfs(words, target, i, cnt + 1);
            }
            visited[i] = false;
        }
    }
}