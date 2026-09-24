import java.io.*;
import java.util.*;

class Solution {
    public static int di[] = {-1, 1, 0, 0, -2, 2, 0, 0, -1, -1, 1, 1}; 
    public static int dj[] = {0, 0, -1, 1, 0, 0, -2, 2,-1, 1, -1, 1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int a = 0; a < 5; a++){
            char arr[][] = new char[5][5];
            for(int i = 0; i < 5; i++){
                String str = places[a][i];
                for(int j = 0; j < 5; j++){
                    arr[i][j] = str.charAt(j);
                }
            }
            boolean check = true;
            naga : for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if(arr[i][j] == 'P'){
                        check = true;
                        for(int d = 0; d < 12; d++){
                            int ni = i + di[d];
                            int nj = j + dj[d];
                            
                            if(ni < 0 || ni >= 5 || nj < 0 || nj >= 5)
                                continue;
                            
                            if(arr[ni][nj] == 'P'){
                                if(d < 4){
                                    answer[a] = 0;
                                    check = false;
                                    break naga;
                                } else if(d < 6){
                                    int mi = (i + ni) / 2;
                                    if(arr[mi][j] != 'X'){
                                        answer[a] = 0;
                                        check = false;
                                        break naga;
                                    }
                                } else if(d < 8){
                                    int mj = (j + nj) / 2;
                                    if(arr[i][mj] != 'X'){
                                        answer[a] = 0;
                                        check = false;
                                        break naga;
                                    }
                                } else {
                                    if(arr[i][nj] != 'X' || arr[ni][j] != 'X'){
                                        answer[a] = 0;
                                        check = false;
                                        break naga;
                                    }
                                }
                            } 
                        }
                    }
                }
            }
            if(check)
                answer[a] = 1;
        }
        return answer;
    }
}