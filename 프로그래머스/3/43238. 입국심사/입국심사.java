import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < times.length; i++){
            max = Math.max(times[i], max);
        }
        long left = 0;
        long right = (long)max * n;
        while(true){
            if(left > right){
                break;
            }
            long mid = (left + right) / 2;
            long total = 0;
            
            for(int i = 0; i < times.length; i++){
                total += mid / times[i];
            }
            if(total >= n){
                answer = mid;
                right = mid - 1;
            }else if(total < n){
                left = mid + 1;
            }
        }
        return answer;
    }
}