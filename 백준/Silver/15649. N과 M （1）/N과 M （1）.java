import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean used[];
    static int result[], arr[];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        used = new boolean[n];
        result = new int[m];
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
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
            if (!used[i]) {
                result[idx] = arr[i];
                used[i] = true;
                perm(idx + 1);
                used[i] = false;
            }
        }
    }
}