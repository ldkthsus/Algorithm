import java.io.*;
import java.util.*;

class Solution {
    public static int total, cnt;
    public static boolean visited[];
    public static List<Integer> graph[];
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        total = n;
        graph = new List[total + 1];
        for(int i = 0; i <= total; i++){
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[total + 1];
        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            Arrays.fill(visited, false);
            cnt = 0;
            dfs(a, b);
            int result = total - cnt;
            answer = Math.min(answer, Math.abs(result - cnt));
        }
        return answer;
    }
    public static void dfs(int start, int block){
        visited[start] = true;
        cnt++;
        for(int i = 0; i < graph[start].size(); i++){
            int num = graph[start].get(i);
            if(num == block)
                continue;
            if(!visited[num]){
                dfs(num, block);
            }
        }
    }
}