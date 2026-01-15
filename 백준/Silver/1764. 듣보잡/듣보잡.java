import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> herd = new HashMap<>();
        Map<String, Integer> see = new HashMap<>();
        for (int i = 0; i < n; i++) {
            herd.put(br.readLine(), 1);
        }
        for (int i = 0; i < m; i++) {
            see.put(br.readLine(), 1);
        }
        int ans = 0;
        List<String> list = new ArrayList<>();
        for (String key : herd.keySet()) {
            if (see.containsKey(key)) {
                ans++;
                list.add(key);
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(ans);
        System.out.println(sb);
    }
}