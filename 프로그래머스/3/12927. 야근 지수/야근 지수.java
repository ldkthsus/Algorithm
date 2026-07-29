import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
        for(int i = 0; i < works.length; i++){
            pq.offer(works[i]);
        }
        for(int i = 0; i < n; i++){
            if(pq.isEmpty()){
                return 0;
            } else {
                int val = pq.poll();
                if(val - 1 != 0){
                    pq.offer(val - 1);
                }
            }
        }
        int size = pq.size();
        for(int i = 0; i < size; i++){
            int val = pq.poll();
            answer += Math.pow(val, 2);
        }
        return answer;
    }
}