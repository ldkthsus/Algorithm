import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            list.add(s.charAt(i));
        }
        for(int i = 0; i < s.length(); i++){
            Stack<Character> stack = new Stack<>();
            boolean check = true;
            for(int j = 0; j < s.length(); j++){
                char ch = list.get(j);
                if(ch == ')' || ch == ']' || ch == '}'){
                    if(stack.isEmpty()){
                        check = false;
                        break;
                    } else {
                        if(stack.peek() == '(' && ch == ')')
                            stack.pop();
                        else if(stack.peek() == '[' && ch == ']')
                            stack.pop();
                        else if(stack.peek() == '{' && ch == '}')
                            stack.pop();
                        else {
                            check = false;
                            break;
                        }
                    }
                } else {
                    stack.push(ch);
                }
            }
            if(check){
                if(stack.isEmpty())
                    answer++;
            }
            list.add(list.get(0));
            list.remove(0);
        }
        return answer;
    }
}