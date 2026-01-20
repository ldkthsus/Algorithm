import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char now = Character.toUpperCase(str.charAt(i));
            if (!map.containsKey(now)) {
                map.put(now, 1);
                max = Math.max(max, map.get(now));
            }
            else {
                map.put(now, map.get(now) + 1);
                max = Math.max(max, map.get(now));
            }
        }
        List<Character> list = new ArrayList<>();
        for (Character key : map.keySet()) {
            int val = map.get(key);
            if (max == val)
                list.add(key);
        }
        if (list.size() > 1)
            System.out.println("?");
        else System.out.println(list.get(0));

    }
}