import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, ans, num;
    public static int arr[][];
    public static int di[] = {-1, 1, 0, 0};
    public static int dj[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;
            else {
                arr = new int[n][n];
                StringTokenizer st;

                for (int i = 0; i < n; i++) {
                    st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < n; j++) {
                        arr[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
                num++;
                ans = Integer.MAX_VALUE;
                bfs();
                System.out.println("Problem " + num + ": " + ans);
            }
        }
    }

    public static void bfs() {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        boolean visited[][] = new boolean[n][n];
        queue.offer(new Point(0, 0, arr[0][0]));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int ni = now.i + di[d];
                int nj = now.j + dj[d];

                if (ni < 0 || ni >= n || nj < 0 || nj >= n || visited[ni][nj]) {
                    continue;
                }
                int val = now.sum + arr[ni][nj];
                if (ni == n - 1 && nj == n - 1) {
                    ans = Math.min(ans, val);
                } else {
                    queue.offer(new Point(ni, nj, val));
                    visited[ni][nj] = true;
                }
            }
        }
    }

    public static class Point implements Comparable<Point> {
        int i;
        int j;
        int sum;

        public Point(int i, int j, int s) {
            this.i = i;
            this.j = j;
            this.sum = s;
        }

        @Override
        public int compareTo(Point o) {
            return this.sum - o.sum;
        }
    }
}