import java.io.*;
import java.util.*;

class Solution {
    public static int di[] = {1, -1, 0, 0};
    public static int dj[] = {0, 0, -1, 1};
    public int solution(String dirs) {
        int answer = 0;
        int si = 0;
        int sj = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('U', 0);
        map.put('D', 1);
        map.put('R', 3);
        map.put('L', 2);
        Map<String, Integer> board = new HashMap<>();
        for(int i = 0; i < dirs.length(); i++){
            char ch = dirs.charAt(i);
            int val = map.get(ch);
            int ni = si + di[val];
            int nj = sj + dj[val];
            
            if(ni < -5 || ni > 5 || nj < -5 || nj > 5)
                continue;
            String str = si + "," + sj + "," + ni + "," + nj;
            String st = ni + "," + nj + "," + si + "," + sj;
            if(!board.containsKey(str) && !map.containsKey(st)){
                board.put(str, 1);
                board.put(st, 1);
                answer++;
            }
            si = ni;
            sj = nj;
        }
        return answer;
    }
}