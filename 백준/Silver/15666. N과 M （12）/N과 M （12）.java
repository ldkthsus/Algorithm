import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, number[], result[];
    public static StringBuilder sb;
    public static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!map.containsKey(num))
                map.put(num, 1);
        }
        number = new int[map.size()];
        result = new int[m];
        sb = new StringBuilder();
        int idx = 0;
        for (int key : map.keySet()) {
            number[idx] = key;
            idx++;
        }
        Arrays.sort(number);
        comb(0, 0);
        System.out.println(sb);
    }

    public static void comb(int idx, int start) {
        if (idx == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < number.length; i++) {
            result[idx] = number[i];
            comb(idx + 1, i);
        }
    }
}