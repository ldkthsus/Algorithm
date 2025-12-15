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

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>(); //약 효능, 약 이름
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.put(a, b);
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < num; j++) {
                int medi = Integer.parseInt(st.nextToken());

                if (map.containsKey(medi)) {
                    temp.append(map.get(medi)).append(" ");
                } else {
                    temp.setLength(0);
                    temp.append("YOU DIED");
                    break;
                }
            }
            sb.append(temp.toString()).append("\n");
        }
        System.out.println(sb);
    }
}