import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int startI = (int) (left / n) + 1;
        int startJ = (int) (left % n) + 1;
        int endI = (int) (right / n) + 1;
        int endJ = (int) (right % n) + 1;
        
        int i = startI;
        int j = startJ;
        List<Integer> list = new ArrayList<>();
        while(true){
            if(i == endI && j == endJ){
                int max = Math.max(i, j);
                list.add(max);
                break;
            }
            int max = Math.max(i, j);
            list.add(max);
            j++;
            if(j > n){
                j = 1;
                i++;
            }
        }
        int answer[] = new int[list.size()];
        for(int a = 0; a < list.size(); a++){
            answer[a] = list.get(a);
        }
        return answer;
    }
}