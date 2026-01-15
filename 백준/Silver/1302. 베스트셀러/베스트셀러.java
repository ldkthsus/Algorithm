import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            if (!map.containsKey(book)) {
                map.put(book, 1);
                max = Math.max(max, 1);
            } else {
                map.put(book, map.get(book) + 1);
                max = Math.max(max, map.get(book));
            }
        }
        List<String> list = new ArrayList<>();
        for(String key : map.keySet()){
            int val = map.get(key);
            if(max == val)
                list.add(key);
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}