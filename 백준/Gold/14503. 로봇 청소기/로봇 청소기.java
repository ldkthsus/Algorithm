import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int di[] = {-1, 0, 1, 0}; //북, 동, 남, 서
    public static int dj[] = {0, 1, 0, -1};
    public static int n, m, cnt;
    public static int arr[][];
    public static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        st = new StringTokenizer(br.readLine());
        int si = Integer.parseInt(st.nextToken());
        int sj = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        robot(si, sj, dir);
        System.out.println(cnt);
    }

    public static void robot(int i, int j, int dir) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i, j, dir));
        if (arr[i][j] == 0) {
            visited[i][j] = true;
            cnt++;
        } else {
            return;
        }
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int direction = now.dir;
            boolean check = false;

            for (int d = 0; d < 4; d++) {
                direction = (direction + 3) % 4;
                int ni = now.i + di[direction];
                int nj = now.j + dj[direction];

                if (ni < 0 || ni >= n || nj < 0 || nj >= m || visited[ni][nj] || arr[ni][nj] == 1)
                    continue;

                queue.offer(new Point(ni, nj, direction));
                visited[ni][nj] = true;
                cnt++;
                check = true;
                break;
            }
            if (!check) {
                int ni = now.i - di[now.dir];
                int nj = now.j - dj[now.dir];

                if (ni < 0 || ni >= n || nj < 0 || nj >= m || arr[ni][nj] == 1)
                    break;
                queue.offer(new Point(ni, nj, now.dir));
            }
        }
    }

    public static class Point {
        int i;
        int j;
        int dir;

        public Point(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.dir = d;
        }
    }
}