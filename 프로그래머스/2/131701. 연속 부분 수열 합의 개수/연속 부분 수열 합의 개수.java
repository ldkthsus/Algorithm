import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= elements.length; i++){
            int start = 0;
            int end = 0;
            int sum = elements[start];
            int cnt = 1;
            
            while(true){
                if(start == elements.length){
                    break;
                }
                if(cnt == i){
                    set.add(sum);
                    sum -= elements[start];
                    start++;
                    cnt--;
                } else {
                    end++;
                    if(end == elements.length)
                        end = 0;
                    sum += elements[end];
                    cnt++;
                }
            }
        }
        answer = set.size();
        return answer;
    }
}