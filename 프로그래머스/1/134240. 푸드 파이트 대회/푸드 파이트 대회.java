import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < food.length; i++){
            int val = food[i] / 2;
            for(int j = 0; j < val; j++){
                list.add(i);
            }
        }
        list.add(0);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));
        }
        
        String str = sb.toString().substring(0, sb.length() - 1);
        StringBuilder temp = new StringBuilder();
        temp.append(str);
        temp.reverse();
        sb.append(temp);
        answer = sb.toString();
        return answer;
    }
}