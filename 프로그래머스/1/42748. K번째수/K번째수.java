import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int answer[] = new int[n];
        int idx = 0;
        
        for(int i = 0; i < n; i++){
            int a = commands[i][0];
            int b = commands[i][1];
            int k = commands[i][2];
            List<Integer> list = new ArrayList<>();
            for(int j = a - 1; j < b; j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            for(int j = 0; j < list.size(); j++){
                if(j == k - 1){
                    answer[idx] = list.get(j);
                    idx++;
                    break;
                }
            }
        }
        return answer;
    }
}