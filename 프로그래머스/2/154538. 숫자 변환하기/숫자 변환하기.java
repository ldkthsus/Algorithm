import java.io.*;
import java.util.*;

class Solution {
    public static int answer;
    public int solution(int x, int y, int n) {
        answer = Integer.MAX_VALUE;
        bfs(x, y, n);
        if(answer == Integer.MAX_VALUE)
            answer = -1;
        return answer;
    }
    public static void bfs(int x, int y, int n){
        Queue<Point> queue = new ArrayDeque<>();
        boolean visited[] = new boolean[1000002];
        queue.offer(new Point(0, x));
        visited[x] = true;
        while(!queue.isEmpty()){
            Point now = queue.poll();
            if(now.num == y){
                answer = Math.min(answer, now.cnt);
            }
            
            for(int i = 0; i < 3; i++){
                int val = 0;
                if(i == 0){
                    val = now.num + n;
                } else if(i == 1){
                    val = now.num * 2;
                } else{
                    val = now.num * 3;
                }
                
                if(val > 1000001 || visited[val])
                    continue;
                queue.offer(new Point(now.cnt + 1, val));
                visited[val] = true;
            }
        }
    }
    public static class Point{
        int cnt;
        int num;
        public Point(int c, int n){
            this.cnt = c;
            this.num = n;
        }
    }
}