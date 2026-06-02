import java.io.*;
import java.util.*;

class Solution {
    public static int cnt, n;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        n = numbers.length;
        dfs(numbers, target, 0, 0);
        answer = cnt;
        return answer;
    }
    public static void dfs(int [] arr, int target, int idx, int sum){
        if(idx == n){
            if(sum == target){
                cnt++;
            }
            return;
        }
        dfs(arr, target, idx + 1, sum + arr[idx]);
        dfs(arr, target, idx + 1, sum - arr[idx]);
    }
}