import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean sosu[] = new boolean[n + 1];
        Arrays.fill(sosu, true);
        int cnt = 1;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(sosu[i]){
                for(int j = i * i; j <= n; j += i){
                    if(sosu[j]){
                        sosu[j] = false;
                        cnt++;
                    }
                }
            }
        }
        answer = n - cnt;
        return answer;
    }
}