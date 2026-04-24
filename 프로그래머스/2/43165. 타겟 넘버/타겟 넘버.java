import java.io.*;
import java.util.*;

class Solution {
    public static int n, ans, cnt, num[];
    public int solution(int[] numbers, int target) {
        int answer = 0;
        n = numbers.length;
        ans = target;
        num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = numbers[i];
        }
        dfs(0, 0);
        answer = cnt;
        return answer;
    }
    public static void dfs(int idx, int sum){
        if(idx == n){
            if(sum == ans){
            cnt++;
            }
            return;
        }
        dfs(idx + 1, sum + num[idx]);
        dfs(idx + 1, sum - num[idx]);
    }
}