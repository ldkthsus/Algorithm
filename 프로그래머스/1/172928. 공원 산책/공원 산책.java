import java.io.*;
import java.util.*;

class Solution {
    public static char arr[][];
    public static int di[] = {-1, 1, 0, 0}; //상, 하, 좌, 우
    public static int dj[] = {0, 0, -1, 1};
    public static int endI, endJ, n, m, stI, stJ;
    public int[] solution(String[] park, String[] routes) {
        n = park.length;
        m = park[0].length();
        arr = new char[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = park[i].charAt(j);
                if(arr[i][j] == 'S'){
                    stI = i;
                    stJ = j;
                }
            }
        }
        bfs(stI, stJ, routes);
        int answer[] = new int[2];
        answer[0] = endI;
        answer[1] = endJ;
        return answer;
    }
    public static void bfs(int i, int j, String [] routes){
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i, j));
        int idx = 0;
        while(true){
            if(idx == routes.length){
                Point po = queue.poll();
                endI = po.i;
                endJ = po.j;
                break;
            }
            Point now = queue.poll();
            boolean check = true;
            String op[] = routes[idx].split(" ");
            int ni = now.i;
            int nj = now.j;
            int val = 0;
            if(op[0].equals("S")){
                val = 1;
            } else if(op[0].equals("W")){
                val = 2;
            } else if(op[0].equals("E")){
                val = 3;
            }
            for(int d = 0; d <= Integer.parseInt(op[1]); d++){
                    ni = now.i + (di[val] * d);
                    nj = now.j + (dj[val] * d);
                    
                    if(ni < 0 || ni >= n || nj < 0 || nj >= m 
                       || arr[ni][nj] == 'X'){
                        check = false;
                        break;
                    }
                }
            if(check){
                queue.offer(new Point(ni, nj));
            } else{
                queue.offer(new Point(now.i, now.j));
            }
            idx++;
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