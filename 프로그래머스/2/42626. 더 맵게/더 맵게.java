import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = scoville.length;
        for(int i = 0; i < n; i++){
            pq.offer(scoville[i]);
        }
        while(true){
            if(pq.peek() >= K){
                break;
            }else{
                if(pq.size() == 1){
                    answer = -1;
                    break;
                }else{
                    int one = pq.poll();
                    int two = pq.poll();
                    int result = one + (two * 2);
                    pq.offer(result);
                    answer++;
                }
            }
        }
        return answer;
    }
}