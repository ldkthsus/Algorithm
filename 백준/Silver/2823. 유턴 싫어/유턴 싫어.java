import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int di[] = {1, 0, -1, 0}; //아래, 우, 위, 좌
    public static int dj[] = {0, 1, 0, -1};
    public static int n, m;
    public static char arr[][];
    public static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char now = str.charAt(j);
                arr[i][j] = now;

                if (now == '.') {
                    list.add(new Point(i, j));
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            check = false;
            dfs(list.get(i).i, list.get(i).j);
            if (!check) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    public static void dfs(int i, int j) {
        int cnt = 0;
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (ni < 0 || ni >= n || nj < 0 || nj >= m || arr[ni][nj] == 'X')
                continue;
            cnt++;
        }
        if (cnt <= 1)
            check = false;
        else check = true;
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