import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Point> stack = new Stack<>();
        
        for(int i = 0; i < numbers.length; i++){
            if(stack.isEmpty()){
                stack.push(new Point(numbers[i], i));
            } else {
                while(true){
                    if(stack.isEmpty()){
                        stack.push(new Point(numbers[i], i));
                        break;
                    }
                    
                    int val = stack.peek().num;
                    if(val < numbers[i]){
                        Point po = stack.pop();
                        answer[po.idx] = numbers[i];
                    } else{
                        stack.push(new Point(numbers[i], i));
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < answer.length; i++){
            if(answer[i] == 0)
                answer[i] = -1;
        }
        return answer;
    }
    public static class Point{
        int num;
        int idx;
        
        public Point(int n, int i){
            this.num = n;
            this.idx = i;
        }
    }
}