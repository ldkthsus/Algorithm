import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        for(int i = 0; i< queue1.length; i++){
            sum1 += queue1[i];
            q1.offer(queue1[i]);
        }
        for(int i = 0; i < queue2.length; i++){
            sum2 += queue2[i];
            q2.offer(queue2[i]);
        }
        int cnt = 0;
        if((sum1 + sum2) % 2 != 0){
            return -1;
        }
        int limit = q1.size() * 3;
        while(true){
            if(sum1 == sum2){
                answer = cnt;
                break;
            }
            else if(sum1 > sum2){
                int val = q1.poll();
                q2.offer(val);
                sum2 += val;
                sum1 -= val;
                
            } else {
                int val = q2.poll();
                q1.offer(val);
                sum1 += val;
                sum2 -= val;
            }
            cnt++;
            if(cnt > limit){
                answer = -1;
                break;
            }
        }
        return answer;
    }
}