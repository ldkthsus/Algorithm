import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, ei, ej, cnt;
    public static boolean arr[][];
    public static int di[] = {-2, -2, 0, 0, 2, 2};
    public static int dj[] = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int si = Integer.parseInt(st.nextToken());
        int sj = Integer.parseInt(st.nextToken());
        ei = Integer.parseInt(st.nextToken());
        ej = Integer.parseInt(st.nextToken());
        arr = new boolean[n][n];
        cnt = 0;
        bfs(si, sj);
        System.out.println(cnt);
    }

    public static void bfs(int i, int j) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i, j));
        arr[i][j] = true;
        boolean check = false;
        naga:
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Point now = queue.poll();

                for (int d = 0; d < 6; d++) {
                    int ni = now.i + di[d];
                    int nj = now.j + dj[d];

                    if (ni < 0 || ni >= n || nj < 0 || nj >= n || arr[ni][nj])
                        continue;

                    if (ni == ei && nj == ej) {
                        check = true;
                        cnt++;
                        break naga;
                    }

                    arr[ni][nj] = true;
                    queue.offer(new Point(ni, nj));
                }
            }
            cnt++;
        }

        if (!check)
            cnt = -1;
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