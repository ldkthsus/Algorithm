import java.io.*;
import java.util.*;

class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long val = 0;
        for(int i = 1; i <= count; i++){
            val += (price * i);
        }
        if(money >= val)
            return answer;
        else return val - money;
    }
}