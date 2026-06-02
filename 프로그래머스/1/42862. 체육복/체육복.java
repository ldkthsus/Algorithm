import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean student[] = new boolean[n + 1];
        Arrays.fill(student, true);
        int answer = n;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < lost.length; i++){
            map.put(lost[i], 1);
            student[lost[i]] = false;
            answer--;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < reserve.length; i++){
            int idx = reserve[i];
            if(map.containsKey(idx)){
                student[idx] = true;
                answer++;
                continue;
            }
            list.add(idx);
        }
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            int idx = list.get(i);
            int pre = idx - 1;
            int next = idx + 1;
            
            if(pre >= 1 && !student[pre]){
                student[pre] = true;
                answer++;
            }else if(next <= n && !student[next]){
                student[next] = true;
                answer++;
            }
        }
        return answer;
    }
}