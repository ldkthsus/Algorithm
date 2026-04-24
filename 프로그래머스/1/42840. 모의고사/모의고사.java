import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int supoja[][] = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        List<Point> list = new ArrayList<>();
        
        for(int i = 0; i < 3; i++){
            int a = 0;
            int b = 0;
            int cnt = 0;
            while(true){
                if(b == answers.length){
                    break;
                }
                if(supoja[i][a] == answers[b]){
                    cnt++;
                }
                a = (a + 1) % supoja[i].length;
                b++;
            }
            list.add(new Point(i + 1, cnt));
        }
        Collections.sort(list);
        int cnt = 1;
        int pre = list.get(0).cnt;
        for(int i = 1; i < list.size(); i++){
            if(pre > list.get(i).cnt){
                break;
            }
            cnt++;
        }
        int answer[] = new int[cnt];
        for(int i = 0; i < cnt; i++){
            answer[i] = list.get(i).num;
        }
        return answer;
    }
    public static class Point implements Comparable<Point>{
        int num;
        int cnt;
        public Point(int n, int c){
            this.num = n;
            this.cnt = c;
        }
        
        @Override
        public int compareTo(Point o){
            if(this.cnt == o.cnt){
                return this.num - o.num;
            }else return o.cnt - this.cnt;
        }
    }
}