import java.io.*;
import java.util.*;

class Solution {
    public static boolean visited[][];
    public static int di[] = {-1, 1, 0, 0};
    public static int dj[] = {0, 0, -1, 1};
    public static int n, m, result, arr[][];
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char ch = maps[i].charAt(j);
                
                if(ch == 'X'){
                    arr[i][j] = -1;
                } else{
                    arr[i][j] = ch - '0';
                }
            }
        }
        
        visited = new boolean[n][m];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] != -1 && !visited[i][j]){
                    result = 0;
                    bfs(i, j);
                    list.add(result);
                }
            }
        }
        if(list.size() == 0){
            int answer[] = new int[1];
            answer[0] = -1;
            return answer;
        }
            Collections.sort(list);
            int answer[] = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
            }
            return answer;
    }
    public static void bfs(int i, int j){
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i, j));
        visited[i][j] = true;
        while(!queue.isEmpty()){
            Point now = queue.poll();
            result += arr[now.i][now.j];
            for(int d = 0; d < 4; d++){
                int ni = now.i + di[d];
                int nj = now.j + dj[d];
                
                if(ni < 0 || ni >= n || nj < 0 || nj >= m || visited[ni][nj]
                  || arr[ni][nj] == -1){
                    continue;
                }
                
                queue.offer(new Point(ni, nj));
                visited[ni][nj] = true;
            }
        }
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