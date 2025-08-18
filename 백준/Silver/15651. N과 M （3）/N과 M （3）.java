import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int num[], result[], n, m;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n];
        result = new int[m];

        for (int i = 1; i <= n; i++) {
            num[i - 1] = i;
        }
        sb = new StringBuilder();
        perm(0);
        System.out.println(sb);
    }

    public static void perm(int idx) {
        if (idx == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            result[idx] = num[i];
            perm(idx + 1);
        }
    }
}