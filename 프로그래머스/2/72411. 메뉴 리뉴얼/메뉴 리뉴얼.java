import java.io.*;
import java.util.*;

class Solution {
    public static TreeMap<String, Integer> map;
    public static String[] arr;
    public String[] solution(String[] orders, int[] course) {
        map = new TreeMap<>();
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < course.length; i++){
            for(int j = 0; j < orders.length; j++){
                String str[] = orders[j].split("");
                if(str.length >= course[i]){
                    arr = new String[course[i]];
                    Arrays.sort(str);
                    dfs(0, 0, course[i], str);
                }
            }
            int max = Integer.MIN_VALUE;
            List<String> temp = new ArrayList<>();
            for(String key : map.keySet()){
                int val = map.get(key);
                if(val >= 2 && max < val){
                    temp.clear();
                    temp.add(key);
                    max = val;
                } else if(max == val){
                    temp.add(key);
                }
            }
            for(int a = 0; a < temp.size(); a++){
                ans.add(temp.get(a));
            }
            map.clear();
        }
        Collections.sort(ans);
        String []answer = new String[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
    public static void dfs(int start, int idx, int target, String[] str){
        if(idx == target){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < idx; i++){
                sb.append(arr[i]);
            }
            if(!map.containsKey(sb.toString()))
                map.put(sb.toString(), 1);
            else map.put(sb.toString(), map.get(sb.toString()) + 1);
            return;
        }
        for(int i = start; i < str.length; i++){
            arr[idx] = str[i];
            dfs(i + 1, idx + 1, target, str);
        }
    }
}