import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Homework arr[] = new Homework[plans.length];
        for(int i = 0; i < plans.length; i++){
            String name = plans[i][0];
            String[] time = plans[i][1].split(":");
            String play = plans[i][2];
            
            arr[i] = new Homework(Integer.parseInt(time[0]), 
                    Integer.parseInt(time[1]), Integer.parseInt(play), name);
        }
        
        PriorityQueue<Remain> stop = new PriorityQueue<>(new Comparator<Remain>(){
            @Override
            public int compare(Remain o1, Remain o2){
                if(o1.hour == o2.hour)
                    return o2.bun - o1.bun;
                else return o2.hour - o1.hour;
            }
        }); //pq에 넣을 때 멈춘 시간을 넣음
        Arrays.sort(arr);
        PriorityQueue<Homework> start = new PriorityQueue<>();
        start.offer(arr[0]);
        int idx = 0;
        
        for(int i = 1; i < arr.length; i++){
            Homework hw = start.peek();
            int front = hw.hour * 60 + hw.bun + hw.play;
            int next = arr[i].hour * 60 + arr[i].bun;
            
            if(front <= next){
                Homework now = start.poll();
                answer[idx] = now.name;
                idx++;
                if(front < next){
                    if(stop.size() > 0){
                        int time = front;
                        while(true){
                            if(stop.isEmpty())
                                break;
                            Remain re = stop.poll();
                            
                            if(re.play + time <= next){
                                answer[idx] = re.name;
                                idx++;
                                if(re.play + time == next)
                                    break;
                            } else {
                                stop.offer(new Remain(arr[i].hour, arr[i].bun, 
                                            time + re.play - next, re.name));
                                break;
                            }
                            time = time + re.play;
                        }
                    }
                }
            } else {
                Homework now = start.poll();
                int val = now.hour * 60 + now.bun + now.play;
                int end = arr[i].hour * 60 + arr[i].bun;
                stop.offer(new Remain(arr[i].hour, arr[i].bun, 
                                      val - end, now.name));
            }
            start.offer(arr[i]);
        }
        Homework last = start.poll();
        answer[idx] = last.name;
        idx++;
        int size = stop.size();
        for(int i = 0; i < size; i++){
            Remain re = stop.poll();
            answer[idx] = re.name;
            idx++;
        }
        return answer;
    }
    public static class Homework implements Comparable<Homework>{
        int hour;
        int bun;
        int play;
        String name;
        
        public Homework(int h, int b, int p, String n){
            this.hour = h;
            this.bun = b;
            this.play = p;
            this.name = n;
        }
        
        @Override
        public int compareTo(Homework o){
            if(this.hour == o.hour)
                return this.bun - o.bun;
            else return this.hour - o.hour;
        }
    }
    
    public static class Remain{
        int hour;
        int bun;
        int play;
        String name;
        
        public Remain(int h, int b, int p, String n){
            this.hour = h;
            this.bun = b;
            this.play = p;
            this.name = n;
        }
    }
}