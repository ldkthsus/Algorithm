import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, number[], result[];
    public static boolean isSelected[];
    public static StringBuilder sb;
    public static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        number = new int[n];
        result = new int[m];
        isSelected = new boolean[n];
        sb = new StringBuilder();
        map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(number);
        perm(0);
        System.out.println(sb);
    }

    public static void perm(int idx) {
        if (idx == m) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < m; i++) {
                temp.append(result[i]).append(" ");
            }
            if (!map.containsKey(temp.toString())) {
                map.put(temp.toString(), 1);
                sb.append(temp);
                sb.append("\n");
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isSelected[i]) {
                result[idx] = number[i];
                isSelected[i] = true;
                perm(idx + 1);
                isSelected[i] = false;
            }
        }
    }
}