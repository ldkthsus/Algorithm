import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < strArr.length; i++){
            String str = strArr[i];
            if(!str.contains("ad")){
                list.add(str);
            }
        }
        String answer[] = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}