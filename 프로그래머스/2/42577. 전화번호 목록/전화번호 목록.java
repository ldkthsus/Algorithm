import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<>();
        
        for(int i=0;i<phone_book.length;i++){
            set.add(phone_book[i]);
        }
        for(String phone : phone_book){
            for(int i=0; i<phone.length();i++){
                if(set.contains(phone.substring(0, i))){
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}