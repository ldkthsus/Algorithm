import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new TreeMap<>();
        int cnt = 0;
        while (true) {
            String str = br.readLine();
            if (str == null) {
                break;
            }
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else map.put(str, 1);
            cnt++;
        }
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            int val = map.get(key);
            double result = (double) val / cnt * 100;
            String ratio = String.format("%.4f", result);
            sb.append(key).append(" ").append(ratio).append("\n");
        }
        System.out.println(sb);
    }
}