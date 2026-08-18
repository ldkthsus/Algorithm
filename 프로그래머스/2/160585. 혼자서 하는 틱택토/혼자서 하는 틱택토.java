import java.io.*;
import java.util.*;

class Solution {
    public static int di[] = {0, 1, 1, 1}; //우, 우대각선, 아래, 좌대각선
    public static int dj[] = {1, 1, 0, -1};
    public int solution(String[] board) {
        int answer = 1;
        char map[][] = new char[3][3];
        int oCnt = 0;
        int xCnt = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'O')
                    oCnt++;
                else if(map[i][j] == 'X')
                    xCnt++;
            }
        }
        if(oCnt < xCnt || oCnt - xCnt > 1) {
            return 0;
        } else{
            boolean xWin = false;
            boolean oWin = false;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    char now = map[i][j];
                    if(map[i][j] == '.')
                        continue;
                        for(int d = 0; d < 4; d++){
                            int ni = i + di[d];
                            int nj = j + dj[d];
                            
                            if(ni < 0 || ni >= 3 || nj < 0 || nj >= 3)
                                continue;
                            
                            if(map[ni][nj] == now){
                                int nextI = ni + di[d];
                                int nextJ = nj + dj[d];
                                
                                if(nextI < 0 || nextI >= 3 || nextJ < 0 || 
                                   nextJ >= 3)
                                    continue;
                                
                                if(now == map[nextI][nextJ])
                                
                                    if(now == 'O'){
                                        if(oCnt != xCnt + 1)
                                            return 0;
                                        else oWin = true;
                                    } else if(now == 'X'){
                                        if(oCnt != xCnt)
                                            return 0;
                                        else xWin = true;
                                    }
                        }
                    }
                }
            }
            if(xWin && oWin)
                return 0;
            else return answer;
        }
    }
}