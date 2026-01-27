import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, arr[][], cnt;
    public static int di[] = {-1, 1, 0, 0};
    public static int dj[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        cnt = 0;
        bfs(0, 0);
        System.out.println(cnt);
    }

    public static void bfs(int i, int j) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean visited[][] = new boolean[n][m];
        queue.offer(new Point(i, j));
        visited[i][j] = true;
        cnt++;
        naga:
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Point now = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int ni = now.i + di[d];
                    int nj = now.j + dj[d];
                    if (ni < 0 || ni >= n || nj < 0 || nj >= m || visited[ni][nj] || arr[ni][nj] == 0)
                        continue;

                    if (ni == n - 1 && nj == m - 1) {
                        cnt++;
                        break naga;
                    }
                    queue.offer(new Point(ni, nj));
                    visited[ni][nj] = true;
                }
            }
            cnt++;
        }
    }

    public static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
