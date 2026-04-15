import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int n = priorities.length;
        Queue<Point> queue = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            
            @Override
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
        
        for(int i = 0; i < n; i++){
            queue.offer(new Point(i, priorities[i]));
            pq.offer(priorities[i]);
        }
        int cnt = 1;
        naga : for(int i = 0; i < n; i++){
            int val = pq.poll();
            for(int j = 0; j < n; j++){
                Point now = queue.poll();
                if(val == now.pri){
                    if(location == now.num){
                        answer = cnt;
                        break naga;
                    }
                    cnt++;
                    break;
                }else{
                    queue.offer(now);
                }
            }
        }
        
        return answer;
    }
    
    public static class Point{
        int num;
        int pri;
        public Point(int n, int p){
            this.num = n;
            this.pri = p;
        }
    }
}