import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        String target = s;
        int remove = 0;
        int cnt = 0;
        while(true){
            if(target.equals("1"))
                break;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < target.length(); i++){
                char now = target.charAt(i);
                if(now == '1')
                    sb.append(1);
                else remove++;
            }
            int result = sb.length();
            StringBuilder temp = new StringBuilder();
            while(true){
                if(result < 2){
                    temp.append(result);
                    temp.reverse();
                    break;
                }
                int mok = result / 2;
                int val = result % 2;
                temp.append(val);
                result = mok;
            }
            target = temp.toString();
            cnt++;
        }
        int answer[] = {cnt, remove};
        return answer;
    }
}