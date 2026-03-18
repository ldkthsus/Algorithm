import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= TC; t++) {
            String str = br.readLine();
            String[] arr = str.split(" ");
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length(); j++) {
                    char now = arr[i].charAt(j);
                    if (Character.isAlphabetic(now)) {
                        char alpha = Character.toUpperCase(now);
                        if (!map.containsKey(alpha)) {
                            map.put(alpha, 1);
                        } else map.put(alpha, map.get(alpha) + 1);
                    }
                }
            }
            int num = 0;
            int cnt = 0;
            boolean check = true;
            boolean first = false;
            for (char key : map.keySet()) {
                int val = map.get(key);
                cnt++;
                if (!first) {
                    num = val;
                    first = true;
                }
                num = Math.min(num, val);
            }
            if (cnt != 26) {
                sb.append("Case ").append(t).append(": Not a pangram\n");
            } else {
                sb.append("Case ").append(t).append(": ");
                if (num == 1) {
                    sb.append("Pangram!");
                } else if (num == 2) {
                    sb.append("Double pangram!!");
                } else {
                    sb.append("Triple pangram!!!");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}