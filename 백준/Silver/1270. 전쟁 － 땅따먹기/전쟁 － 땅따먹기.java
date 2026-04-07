import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(br.readLine());
            Map<Long, Integer> map = new HashMap<>();
            int n = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++) {
                long num = Long.parseLong(st.nextToken());
                if (!map.containsKey(num)) {
                    map.put(num, 1);
                } else map.put(num, map.get(num) + 1);
            }
            boolean check = false;
            for (long key : map.keySet()) {
                int val = map.get(key);
                if (val > n / 2) {
                    sb.append(key).append("\n");
                    check = true;
                    break;
                }
            }
            if (!check)
                sb.append("SYJKGW").append("\n");
        }
        System.out.println(sb);
    }
}