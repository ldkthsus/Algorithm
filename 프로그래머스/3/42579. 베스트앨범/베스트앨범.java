import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> map = new HashMap<>();
        for(int i =0 ;i<genres.length;i++){
            if(!map.containsKey(genres[i])){
                map.put(genres[i], plays[i]);
            }
            else{
                map.put(genres[i], (map.get(genres[i])+plays[i]));
            }
        }
        
        System.out.println(map);

        Music arr[] = new Music[genres.length];
        for(int i=0;i<genres.length;i++){
            arr[i] = new Music(i, plays[i], map.get(genres[i]), genres[i]);
        }
        
        Arrays.sort(arr);
        for(int i =0 ; i<arr.length;i++){
            System.out.println("num : " + arr[i].num +" play : " + arr[i].play + " sum : " + arr[i].sum + " genre : " + arr[i].genre);
        }
        
        Map<String, Integer> hash = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(!hash.containsKey(arr[i].genre)){
                hash.put(arr[i].genre, 1);
            }
            else{
                if(hash.get(arr[i].genre) >= 2){
                    continue;
                }
                hash.put(arr[i].genre, hash.get(arr[i].genre)+1);
            }
            list.add(arr[i].num);
        }
        int answer[] = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
    
    public static class Music implements Comparable<Music>{
        int num;
        int play;
        int sum;
        String genre;
        public Music(int n, int p, int s, String genre){
            this.num = n;
            this.play = p;
            this.sum=s;
            this.genre = genre;
        }
        
        @Override
        public int compareTo(Music o){
            if(this.sum == o.sum){
                 if(this.play == o.play){
                return this.num - o.num;
            }
                return o.play-this.play;
            }
            return o.sum-this.sum;
        }
        
    }
}