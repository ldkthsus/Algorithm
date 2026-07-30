import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        Point arr[] = new Point[n + 1];
        int idx = 1;
        naga : while(true){
            if((idx / w) % 2 == 0){
                for(int i = 0; i < w; i++){
                    if(idx % w == 0){
                        arr[idx] = new Point(idx / w - 1, i);
                        idx++;
                    } else {
                        arr[idx] = new Point(idx / w, i);
                        idx++;
                    }
                    if(idx == n + 1){
                        break naga;
                    }
                }
            } 
            if((idx / w) % 2 != 0){
                for(int i = w - 1; i >= 0; i--){
                    if(idx % w == 0){
                        arr[idx] = new Point(idx / w - 1, i);
                        idx++;
                    }
                    else {
                        arr[idx] = new Point(idx / w, i);
                        idx++;
                    }
                    if(idx == n + 1){
                        break naga;
                    }
                }
            }
        }
        int target = arr[num].j;
        int top = 0;
        for(int i = 1; i <= n; i++){
            if(arr[i].j == target){
                top = arr[i].i;
            }
        }
        answer = top - arr[num].i + 1;
        return answer;
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