import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, 0};
        int start = 0;
        int end = 0;
        int sum = sequence[end];
        int min = Integer.MAX_VALUE;
        while(true){
            if(sum < k){
                if(end < sequence.length - 1){
                    end++;
                    sum += sequence[end];
                } else break;
            } else if(sum > k){
                sum -= sequence[start];
                start++;
            } else{
                if(min > end - start){
                    min = end - start;
                    answer[0] = start;
                    answer[1] = end;
                }
                if(end < sequence.length - 1){
                    end++;
                    sum += sequence[end];
                } else break;
            }
        }
        return answer;
    }
}