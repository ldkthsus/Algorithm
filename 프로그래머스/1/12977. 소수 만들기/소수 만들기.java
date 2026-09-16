import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int a = j + 1; a < nums.length; a++){
                    int sum = nums[i] + nums[j] + nums[a];
                    list.add(sum);
                }
            }
        }
        for(int i = 0; i < list.size(); i++){
            if(check(list.get(i)))
                answer++;
        }
        return answer;
    }
    public static boolean check(int n){
        if(n == 0 || n == 1)
            return false;
        if(n == 2)
            return true;
        if(n % 2 == 0)
            return false;
        for(int i = 3; i * i <= n; i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
}