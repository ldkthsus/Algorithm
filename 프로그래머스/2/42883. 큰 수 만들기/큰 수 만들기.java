import java.io.*;
import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int n = number.length();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            int now = number.charAt(i) - '0';
            if(stack.isEmpty()){
                stack.push(now);
            } else{
                while(true){
                    if(!stack.isEmpty() && stack.peek() < now && k > 0){
                        stack.pop();
                        k--;
                    } else{
                        stack.push(now);
                        break;
                    }
                }
            }
        }
        if(k > 0){
            while(true){
                stack.pop();
                k--;
                if(k == 0)
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for(int i = 0; i < size; i++){
            sb.append(stack.pop());
        }
        answer = sb.reverse().toString();
        return answer;
    }
}