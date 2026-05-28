import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Point> stack = new Stack<>();
        int time = 1;
        for(int i = 0; i < n; i++){
            if(stack.isEmpty()){
                stack.push(new Point(prices[i], i));
                time++;
            }else{
                int price = stack.peek().val;
                int now = prices[i];
                
                if(price <= now){
                    stack.push(new Point(prices[i], i));
                } else {
                    int size = stack.size();
                    for(int j = 0; j < size; j++){
                        Point po = stack.pop();
                        if(po.val <= now){
                            stack.push(po);
                            break;
                        }else {
                            answer[po.idx] = time - (po.idx + 1);
                        }
                    }
                    stack.push(new Point(now, i));
                }
                time++;
            }
        }
        time--;
        int size = stack.size();
        for(int i = 0; i < size; i++){
            Point po = stack.pop();
            answer[po.idx] = time - (po.idx + 1);
        }
        return answer;
    }
    public static class Point{
        int val;
        int idx;
        public Point(int v, int i){
            this.val = v;
            this.idx = i;
        }
    }
}