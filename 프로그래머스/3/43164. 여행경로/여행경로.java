import java.io.*;
import java.util.*;

class Solution {
    public static PriorityQueue<String> pq;
    public static int n;
    public static boolean visited[];
    public static StringBuilder sb;
    
    public String[] solution(String[][] tickets) {
        pq = new PriorityQueue<>();
        n = tickets.length;
        visited = new boolean[n];
        sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            String start = tickets[i][0];
            if(start.equals("ICN")){
                Arrays.fill(visited, false);
                sb.setLength(0);
                dfs(tickets, i, 1);
            }
        }
        String ans = pq.poll();
        String answer[] = new String[ans.length() / 3];
        int idx = 0;
        for(int i = 0; i < ans.length(); i += 3){
            String str = "";
            for(int j = 0; j < 3; j++){
                str += String.valueOf(ans.charAt(i + j));
            }
            answer[idx] = str;
            idx++;
        }
        return answer;
    }
    public static void dfs(String [][] tickets, int idx, int depth){
        visited[idx] = true;
        sb.append(tickets[idx][0]);
        if(depth == n){
            sb.append(tickets[idx][1]);
            pq.offer(sb.toString());
            visited[idx] = false;
            sb.delete(sb.length() - 6, sb.length());
            return;
        }
        
        for(int i = 0; i < n; i++){
            String now = tickets[idx][1];
            String next = tickets[i][0];
            
            if(now.equals(next) && !visited[i]){
                dfs(tickets, i, depth + 1);
            }
        }
         visited[idx] = false;
         sb.delete(sb.length() - 3, sb.length());
    }
}