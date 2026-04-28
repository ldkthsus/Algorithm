import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(citations[i]);
        }
        Collections.sort(list, Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            int val = list.get(i);
            if(val >= i + 1){
                answer = i + 1;
            }
        }
        return answer;
    }
}