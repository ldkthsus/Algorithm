import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int n = order.length;
        int num = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            int now = order[i];
            
            while(num < now){
                stack.push(num);
                num++;
            }
            if(num == now){
                answer++;
                num++;
            }else if(!stack.isEmpty() && stack.peek() == now){
                answer++;
                stack.pop();
            }else break;
        }
        return answer;
    }
}