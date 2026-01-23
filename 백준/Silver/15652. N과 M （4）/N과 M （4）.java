import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, result[];
    public static boolean isUsed[];
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isUsed = new boolean[n];
        result = new int[m];
        sb = new StringBuilder();
        perm(0);
        System.out.println(sb);
    }

    public static void perm(int idx) {
        if (idx == m) {
            for (int j = 0; j < m; j++) {
                sb.append(result[j]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (idx == 0) {
                result[idx] = i;
                perm(idx + 1);
            } else {
                if (result[idx - 1] <= i) {
                    result[idx] = i;
                    perm(idx + 1);
                }
            }
        }
    }
}