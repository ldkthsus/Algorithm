import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n ; i++){
            String str = br.readLine();
            if(!map.containsKey(str)){
                map.put(str, 1);
            }
        }

        Word arr[] = new Word[map.size()];
        int idx = 0;
        for(String key : map.keySet()){
            arr[idx] = new Word(key, key.length());
            idx++;
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i].str).append("\n");
        }
        System.out.println(sb);
    }
    public static class Word implements Comparable<Word>{
        String str;
        int len;

        public Word(String s, int l){
            this.str = s;
            this.len = l;
        }
        @Override
        public int compareTo(Word o){
            if(this.len == o.len){
                return this.str.compareTo(o.str);
            }else return this.len - o.len;
        }
    }
}