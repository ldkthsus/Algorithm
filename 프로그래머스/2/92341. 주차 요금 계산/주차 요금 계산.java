import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> manage = new HashMap<>();
        Map<String, Integer> record = new HashMap<>();
        
        for(int i = 0; i < records.length; i++){
            String str[] = records[i].split(" ");
            if(str[2].equals("IN")){
                String num = str[1];
                String time[] = str[0].split(":");
                int hour = Integer.parseInt(time[0]);
                int bun = Integer.parseInt(time[1]);
                int result = hour * 60 + bun;
                manage.put(num, result);
            } else{
                int value = manage.get(str[1]); //입차한 시간
                String time[] = str[0].split(":");
                int hour = Integer.parseInt(time[0]);
                int bun = Integer.parseInt(time[1]);
                int result = hour * 60 + bun;
                
                if(!record.containsKey(str[1])){
                    record.put(str[1], result - value);
                } else {
                    record.put(str[1], record.get(str[1]) + (result - value));
                }
                manage.remove(str[1]);
            }
        }
        if(manage.size() > 0){ //출차 처리 못함
            for(String key : manage.keySet()){
                int result = 23 * 60 + 59;
                int value = manage.get(key);
                
                if(!record.containsKey(key)){
                    record.put(key, result - value);
                } else {
                    record.put(key, record.get(key) + (result - value));
                }
            }
        }
        Car arr[] = new Car[record.size()];
        int idx = 0;
        for(String key : record.keySet()){
            arr[idx] = new Car(Integer.parseInt(key), record.get(key));
            idx++;
        }
        Arrays.sort(arr);
        int answer[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            if(arr[i].pay <= fees[0]){
                answer[i] = fees[1];
            } else {
                int rest = arr[i].pay - fees[0]; //기본 시간 뺌
                int val = rest / fees[2];
                if(rest % fees[2] > 0)
                    val++;
                int result = val * fees[3];
                answer[i] = fees[1] + result;
            }
        }
        return answer;
    }
    public static class Car implements Comparable<Car>{
        int number;
        int pay;
        public Car(int n, int p){
            this.number = n;
            this.pay = p;
        }
        
        @Override
        public int compareTo(Car o){
            return this.number - o.number;
        }
    }
}