import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        int n = progresses.length;
        for(int i = 0; i < n; i++){
            int rest = 100 - progresses[i];
            int days = rest / speeds[i];
            if(rest % speeds[i] != 0){
                days++;
            }
            queue.offer(days);
        }
        List<Integer> list = new ArrayList<>();
        int stan = queue.peek();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            int now = queue.poll();
            if(stan < now){
                list.add(cnt);
                cnt = 1;
                stan = now;
            }else{
                cnt++;
            }
        }
        list.add(cnt);
        int answer[] = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}