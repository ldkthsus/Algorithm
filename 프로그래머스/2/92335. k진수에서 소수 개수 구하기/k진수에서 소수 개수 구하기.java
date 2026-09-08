import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        int rest = n;
        while(true){
            if(rest < k){
                sb.append(rest);
                sb.reverse();
                break;
            }
            rest = n / k;
            int val = n % k;
            sb.append(val);
            n = rest;
        }
        String str = sb.toString();
        sb.setLength(0);
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '0'){
                if(sb.length() == 0)
                    continue;
                else {
                    long num = Long.parseLong(sb.toString());
                    if(check(num)){
                        answer++;
                    }
                    sb.setLength(0);
                }
            } else {
                sb.append(ch);
            }
        }
        if(sb.length() > 0){
            long num = Long.parseLong(sb.toString());
            if(check(num)){
                answer++;
            }
        }
        return answer;
    }
    public static boolean check(long n){
        if(n < 2)
            return false;
        if(n == 2) 
            return true;
        if(n % 2 == 0)
            return false;
        for(int i = 3; i <= Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
}