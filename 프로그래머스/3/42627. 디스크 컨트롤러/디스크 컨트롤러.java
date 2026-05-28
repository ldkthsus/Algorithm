
import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int n = jobs.length;
        PriorityQueue<Point> timePq = new PriorityQueue<>(new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2){
                return o1.start - o2.start;
                }
            });
        
        for(int i = 0; i < n; i++){
            timePq.offer(new Point(jobs[i][0], jobs[i][1], i));
        }
        
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2){
                if(o1.need == o2.need){
                    if(o1.start == o2.start){
                        return o1.idx - o2.idx;
                    } else return o1.start - o2.start;
                } else return o1.need - o2.need;
            }
        });
        int time = 0;
        int sum = 0;
        while(true){
            int size = timePq.size();
            if(timePq.isEmpty() && pq.isEmpty()){
                break;
            }
            for(int i = 0; i < size; i++){
                Point po = timePq.poll();
                if(po.start > time){
                    timePq.offer(po);
                    break;
                }
                pq.offer(po);
            }
            
            Point po;
            if(pq.isEmpty()){
                po = timePq.poll();
                time = po.start;
             } else{
                po = pq.poll();
             }
            time += po.need;
            int result = time - po.start;
            sum += result;
        }
        answer = sum / n;
        return answer;
    }
    public static class Point {
        int start;
        int need;
        int idx;
        public Point(int s, int n, int i){
            this.start = s;
            this.need = n;
            this.idx = i;
        }
    }
}