import java.io.*;
import java.util.*;

class Solution {
    public static int cnt, answer, result[];
    public static String alpha[] = {"A", "E", "I", "O", "U"};
    public static String ans;
    public int solution(String word) {
        cnt = 0;
        ans = word;
        result = new int[5];
        dfs(0);
        return answer;
    }
    public static void dfs(int idx){
        if(idx > 0){
            cnt++;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < idx; i++){
                int val = result[i];
                sb.append(alpha[val]);
            }
            String temp = sb.toString();
            if(temp.equals(ans)){
                answer = cnt;
                return;
            }
        }
        if(idx == 5){
            return;
        }
        for(int i = 0; i < 5; i++){
            result[idx] = i;
            dfs(idx + 1);
        }
    }
}