import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int arr[][], n, m, ans;
    public static int di[] = {1, 1, 1};
    public static int dj[] = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            bfs(0, i, -1, arr[0][i]);
        }
        System.out.println(ans);
    }

    public static void bfs(int i, int j, int dir, int val) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i, j, dir, val));

        naga:
        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int d = 0; d < 3; d++) {
                int ni = now.i + di[d];
                int nj = now.j + dj[d];

                if (now.dir == d)
                    continue;

                if (nj < 0 || nj >= m || ni >= n)
                    continue;

                if (ni == n - 1) {
                    ans = Math.min(ans, now.val + arr[ni][nj]);
                }
                
                queue.offer(new Point(ni, nj, d, now.val + arr[ni][nj]));
            }
        }
    }

    public static class Point {
        int i;
        int j;
        int dir;
        int val;

        public Point(int i, int j, int d, int v) {
            this.i = i;
            this.j = j;
            this.dir = d;
            this.val = v;
        }
    }
}