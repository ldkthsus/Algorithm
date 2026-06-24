import java.io.*;
import java.util.*;

class Solution {
    public String solution(String polynomial) {
        String answer = "";
        String pol[] = polynomial.split(" ");
        List<Integer> xList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < pol.length; i++){
            if(pol[i].contains("x")){
                if(pol[i].length() == 1){
                    xList.add(1);
                } else{
                String str = pol[i].substring(0, pol[i].length() - 1);
                xList.add(Integer.parseInt(str));
                }
            } else if(pol[i].contains("+")){
                continue;
            } else{
               list.add(Integer.parseInt(pol[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        if(xList.size() > 0){
            for(int i = 0; i < xList.size(); i++){
                sum += xList.get(i);
            }
        if(sum == 1){
            sb.append("x");
        } else{
            sb.append(sum).append("x");
            }
        }
        sum = 0;
        if(list.size() > 0){
            for(int i = 0; i < list.size(); i++){
                sum += list.get(i);
            }
            if(sb.length() == 0){
                sb.append(sum);
            } else{
                sb.append(" + ").append(sum);
            }
        }
        answer = sb.toString();
        return answer;
    }
}