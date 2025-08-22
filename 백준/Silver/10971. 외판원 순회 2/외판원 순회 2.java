import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int map[][];
    public static boolean visited[];
    public static int start, n, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            start = i;
            visited[start] = true;
            for (int j = 0; j < n; j++) {
                if (map[start][j] > 0) {
                    visited[j] = true;
                    dfs(j, 1, map[start][j]);
                    visited[j] = false;
                }
            }
            visited[start] = false;
        }
        System.out.println(ans);
    }

    public static void dfs(int begin, int depth, int sum) {
        if (depth == n - 1) {
            if (map[begin][start] > 0) {
                ans = Math.min(ans, sum + map[begin][start]);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (map[begin][i] > 0 && !visited[i]) {
                visited[i] = true;
                dfs(i, depth + 1, sum + map[begin][i]);
                visited[i] = false;
            }
        }
    }
}