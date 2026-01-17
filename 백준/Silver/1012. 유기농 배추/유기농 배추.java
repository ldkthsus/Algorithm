import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, k, cnt, arr[][];
    public static boolean visited[][];
    public static int di[] = {-1, 1, 0, 0}; //상, 하, 좌, 우
    public static int dj[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[y][x] = 1;
            }
            cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
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

                if (ni < 0 || ni >= n || nj < 0 || nj >= m || visited[ni][nj] || arr[ni][nj] == 0)
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