import java.io.*;
import java.util.*;

class Solution {
    public static int N;
    public static List<Integer> graph[];
    public static boolean visited[];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        graph = new List[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers[i].length; j++){
                if(i == j)
                    continue;
                
                if(computers[i][j] == 1){
                    graph[i].add(j);
                }
            }
        }
        
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    public static void dfs(int idx){
        visited[idx] = true;
        
        for(int i = 0; i < graph[idx].size(); i++){
            if(!visited[graph[idx].get(i)])
                dfs(graph[idx].get(i));
        }
    }
}