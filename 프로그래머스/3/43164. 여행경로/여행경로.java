import java.io.*;
import java.util.*;

class Solution {
    public static int n;
    public static StringBuilder sb;
    public static PriorityQueue<String> pq;
    public static boolean visited[];
    
    public String[] solution(String[][] tickets) {
        sb = new StringBuilder();
        pq = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s1.compareTo(s2);
            }
        });
        n = tickets.length;
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            String start = tickets[i][0];
            if(start.equals("ICN")){
                sb.setLength(0);
                Arrays.fill(visited, false);
                sb.append("ICN");
                dfs(i, tickets, 1);
            }
        }
        
        String ans = pq.poll();
        int size = ans.length();        
        String [] answer = new String [size / 3];
        int idx = 0;
        for(int i = 0; i < size; i+= 3){
            StringBuilder temp = new StringBuilder();
            for(int j = i; j < i + 3; j++){
                temp.append(ans.charAt(j));
            }
            answer[idx] = temp.toString();
            idx++;
        }

        return answer;
    }
    public static void dfs(int idx, String [][] tickets, int cnt){
        visited[idx] = true;
        sb.append(tickets[idx][1]);
        if(cnt == n){
            pq.offer(sb.toString());
            return;
        }
        for(int i = 0; i < n; i++){
            String next = tickets[idx][1];
            if(next.equals(tickets[i][0]) && !visited[i]){
                dfs(i, tickets, cnt + 1);
                visited[i] = false;
                sb.delete(sb.length() - 3, sb.length());
            }
        }
    }
}