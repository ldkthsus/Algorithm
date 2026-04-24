import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int n = sizes.length;
        List<Integer> maxList = new ArrayList<>();
        List<Integer> minList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int a = sizes[i][0];
            int b = sizes[i][1];
            
            int max = Math.max(a, b);
            int min = Math.min(a, b);
            maxList.add(max);
            minList.add(min);
        }
        Collections.sort(maxList, Collections.reverseOrder());
        Collections.sort(minList, Collections.reverseOrder());
        answer = maxList.get(0) * minList.get(0);
        return answer;
    }
}