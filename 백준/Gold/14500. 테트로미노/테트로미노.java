import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int di[] = {-1, 1, 0, 0};
    public static int dj[] = {0, 0, -1, 1};
    public static Point te[][] = {
            {new Point(0, 0), new Point(0, 1), new Point(-1, 1), new Point(0, 2)}, //ㅗ
            {new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2)}, //ㅜ
            {new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(-1, 1)}, //ㅓ
            {new Point(0, 0), new Point(0, 1), new Point(-1, 0), new Point(1, 0)} //ㅏ
    };
    public static int max, n, m;
    public static int arr[][];
    public static boolean visited[][];

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
        max = Integer.MIN_VALUE;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, 0, 0);
                check(i, j);
            }
        }
        System.out.println(max);
    }

    public static void dfs(int i, int j, int sum, int cnt) {
        visited[i][j] = true;
        if (cnt == 4) {
            max = Math.max(sum, max);
            return;
        }
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (ni < 0 || ni >= n || nj < 0 || nj >= m || visited[ni][nj])
                continue;
            dfs(ni, nj, sum + arr[ni][nj], cnt + 1);
            visited[ni][nj] = false;
        }
        visited[i][j] = false;
    }

    public static void check(int i, int j) {
        for (int a = 0; a < 4; a++) {
            int sum = 0;
            boolean isOk = true;
            for (int b = 0; b < 4; b++) {
                int ni = i + te[a][b].i;
                int nj = j + te[a][b].j;

                if (ni < 0 || ni >= n || nj < 0 || nj >= m) {
                    isOk = false;
                    break;
                }
                sum += arr[ni][nj];
            }
            if (isOk)
                max = Math.max(max, sum);
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