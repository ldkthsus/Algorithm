import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static int n, ans, arr[][];
    public static int di[] = {-1, 1, 0, 0};
    public static int dj[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(ans);
    }

    public static void bfs() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        boolean visited[][] = new boolean[n][n];
        pq.offer(new Point(0, 0, 0));
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Point now = pq.poll();

            for (int d = 0; d < 4; d++) {
                int ni = now.i + di[d];
                int nj = now.j + dj[d];

                if (ni < 0 || ni >= n || nj < 0 || nj >= n || visited[ni][nj])
                    continue;

                if (ni == n - 1 && nj == n - 1) {
                    ans = Math.min(ans, now.cnt);
                }

                if (arr[ni][nj] == 0) {
                    pq.offer(new Point(ni, nj, now.cnt + 1));
                    visited[ni][nj] = true;

                } else {
                    pq.offer(new Point(ni, nj, now.cnt));
                    visited[ni][nj] = true;
                }
            }
        }
    }

    public static class Point implements Comparable<Point> {
        int i;
        int j;
        int cnt;

        public Point(int i, int j, int c) {
            this.i = i;
            this.j = j;
            this.cnt = c;
        }

        @Override
        public int compareTo(Point o) {
            return this.cnt - o.cnt;
        }
    }
}