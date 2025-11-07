import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, map[][], ans, max, cnt;
    public static int di[] = {-1, 1, 0, 0};
    public static int dj[] = {0, 0, -1, 1};
    public static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(st.nextToken());
                list.add(val);
                max = Math.max(max, val);
            }
        }

        for (int i = 0; i <= max; i++) {

            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    int val = list.get(a * n + b);
                    if (val <= i) {
                        map[a][b] = -1;
                    } else {
                        map[a][b] = val;
                    }
                }
            }

            cnt = 0;
            visited = new boolean[n][n];
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    if (map[a][b] != -1 && !visited[a][b]) {
                        bfs(a, b);
                        cnt++;
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }

    public static void bfs(int i, int j) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i, j));
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int ni = now.i + di[d];
                int nj = now.j + dj[d];

                if (ni < 0 || ni >= n || nj < 0 || nj >= n || visited[ni][nj] || map[ni][nj] == -1)
                    continue;

                queue.offer(new Point(ni, nj));
                visited[ni][nj] = true;
            }
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