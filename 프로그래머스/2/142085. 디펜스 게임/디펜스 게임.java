import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
        int sol = n;
        boolean check = false;
        for(int i = 0; i < enemy.length; i++){
            sol -= enemy[i];
            pq.offer(enemy[i]);
            if(sol < 0){
                sol += pq.poll();
                k--;
                if(k < 0){
                    answer = i;
                    check = true;
                    break;
                }
            }
        }
        if(!check)
            answer = enemy.length;
        return answer;
    }
}