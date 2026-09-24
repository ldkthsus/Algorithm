import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int arr[][] = new int[rows][columns];
        int num = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                arr[i][j] = num;
                num++;
            }
        }
        int idx = 0;
        for(int a = 0; a < queries.length; a++){
            int x1 = queries[a][0] - 1;
            int y1 = queries[a][1] - 1;
            int x2 = queries[a][2] - 1;
            int y2 = queries[a][3] - 1;
            
            int pre = arr[x1][y1];
            int min = pre;
            for(int j = y1; j < y2; j++){ //1
                int temp = arr[x1][j + 1]; //다음 값
                arr[x1][j + 1] = pre;
                min = Math.min(min, temp);
                pre = temp;  
            }
            
            for(int i = x1; i < x2; i++){ //2
                int temp = arr[i + 1][y2];
                arr[i + 1][y2] = pre;
                min = Math.min(min, temp);
                pre = temp;
            }
            
            for(int j = y2; j > y1; j--){ //3
                int temp = arr[x2][j - 1];
                arr[x2][j - 1] = pre;
                min = Math.min(min, temp);
                pre = temp;
            }
            
            for(int i = x2; i > x1; i--){ //4
                int temp = arr[i - 1][y1];
                arr[i - 1][y1] = pre;
                min = Math.min(min, temp);
                pre = temp;
            }
            answer[idx] = min;
            idx++;
        }
        return answer;
    }
}