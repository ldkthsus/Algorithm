import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            int answer[] = {-1};
            return answer;
        } else{
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for(int i = 0; i < arr.length; i++){
                if(min > arr[i]){
                    min = arr[i];
                    idx = i;
                }
            }
            int answer[] = new int[arr.length - 1];
            int index = 0;
            for(int i = 0; i < arr.length; i++){
                if(i == idx)
                    continue;
                answer[index] = arr[i];
                index++;
            }
            return answer;
        }
    }
}