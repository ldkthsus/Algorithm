import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb;
    public static int n, m, start;
    public static boolean arr[][], check[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        arr = new boolean[n + 1][n + 1];
        check = new boolean[n + 1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = true;
            arr[b][a] = true;
        }
        sb.append(start).append(" ");
        dfs(start);
        sb.append("\n");
        Arrays.fill(check, false);
        bfs(start);
        System.out.println(sb);
    }

    public static void dfs(int v) {
        for (int i = 1; i <= n; i++) {
            check[v] = true;
            if (arr[v][i] && !check[i]) {
                sb.append(i).append(" ");
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(v);
        check[v] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");
            for (int i = 1; i <= n; i++) {
                if (arr[now][i] && !check[i]) {
                    queue.offer(i);
                    check[i] = true;
                }
            }
        }
    }
}