import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Time []arr = new Time[book_time.length];
        for(int i = 0; i < book_time.length; i++){
            String sh = book_time[i][0].substring(0, 2);
            String sm = book_time[i][0].substring(3, 5);
            String eh = book_time[i][1].substring(0, 2);
            String em = book_time[i][1].substring(3, 5);
            
            arr[i] = new Time(Integer.parseInt(sh), Integer.parseInt(sm), Integer.parseInt(eh), Integer.parseInt(em));                
        }
        Arrays.sort(arr);
        List<Point> list = new ArrayList<>();
        list.add(new Point(arr[0].endHour, arr[0].endMin));
        for(int i = 1; i < arr.length; i++){
            int size = list.size();
            for(int j = 0; j < size; j++){
                int eh = list.get(j).eh;
                int em = list.get(j).em + 10;
                if(em >= 60){
                    eh++;
                    em = em - 60;
                }
                 if(eh == arr[i].startHour){
                    if(em <= arr[i].startMin){
                        list.set(j, new Point(arr[i].endHour, arr[i].endMin));
                        break;
                    }
                }
                else if(eh < arr[i].startHour){
                    list.set(j, new Point(arr[i].endHour, arr[i].endMin));
                    break;
                }
                
                if(j == size - 1){
                    list.add(new Point(arr[i].endHour, arr[i].endMin));
                }
            }
        }
        return list.size();
    }
    public static class Time implements Comparable<Time>{
        int startHour;
        int startMin;
        int endHour;
        int endMin;
        public Time(int sh, int sm, int eh, int em){
            this.startHour = sh;
            this.startMin = sm;
            this.endHour = eh;
            this.endMin = em;
        }
        
        @Override
        public int compareTo(Time o){
            if(this.startHour == o.startHour){
                return this.startMin - o.startMin;
            }
            else return this.startHour - o.startHour;
        }
    }
    public static class Point{
        int eh;
        int em;
        public Point(int eh, int em){
            this.eh = eh;
            this.em = em;
        }
    }
}