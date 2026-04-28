import java.io.*;
import java.util.*;

class Solution {
    public static int N, M, arr[][], cnt;
    public static boolean visited[][];
    public static int di[] = {-1, 1, 0, 0};
    public static int dj[] = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length;
        arr = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                arr[i][j] = maps[i][j];
            }
        }
        visited = new boolean[N][M];
        bfs(0, 0);
        answer = cnt;
        return answer;
    }
    public static void bfs(int i, int j){
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i, j));
        visited[i][j] = true;
        cnt++;
        boolean check = false;
        naga : while(!queue.isEmpty()){
            int size = queue.size();
            for(int s = 0; s < size; s++){
            Point now = queue.poll();
            
            for(int d = 0; d < 4; d++){
                int ni = now.i + di[d];
                int nj = now.j + dj[d];
                
                if(ni < 0 || ni >= N || nj < 0 || nj >= M || visited[ni][nj]
                  || arr[ni][nj] == 0)
                    continue;
                
                if(ni == N - 1 && nj == M -1){
                    cnt++;
                    check = true;
                    break naga;
                }
                
                queue.offer(new Point(ni, nj));
                visited[ni][nj] = true;
                }
            }
            cnt++;
        }
        if(!check)
            cnt = -1;
    }
    
    public static class Point{
        int i;
        int j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}