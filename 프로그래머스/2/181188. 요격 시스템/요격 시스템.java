import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Point arr[] = new Point[targets.length];
        for(int i = 0; i < targets.length; i++){
            arr[i] = new Point(targets[i][0], targets[i][1]);
        }
        Arrays.sort(arr);
        int idx = 0;
        answer++;
        int value = 0;
        while(true){
            if(idx == arr.length)
                break;
            
            if(value == 0){
                value = arr[idx].j;
            } else{
                if(value <= arr[idx].i){
                    answer++;
                    value = arr[idx].j;
                }
            }
            idx++;
        }
        return answer;
    }
    public static class Point implements Comparable<Point>{
        int i;
        int j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
        
        @Override
        public int compareTo(Point o){
            if(this.j == o.j)
                return this.i - o.i;
            else return this.j - o.j;
        }
    } 
}