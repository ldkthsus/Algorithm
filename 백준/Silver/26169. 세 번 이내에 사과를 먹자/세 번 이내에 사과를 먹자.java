import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int arr[][];
    public static int di[] = {-1, 1, 0, 0};
    public static int dj[] = {0, 0, -1, 1};
    public static boolean check, visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int si = Integer.parseInt(st.nextToken());
        int sj = Integer.parseInt(st.nextToken());
        visited = new boolean[5][5];
        dfs(si, sj, 0, 0);
        if (check)
            System.out.println(1);
        else System.out.println(0);
    }

    public static void dfs(int i, int j, int cnt, int apple) {
        if (arr[i][j] == 1)
            apple++;
        if (cnt <= 3 && apple >= 2) {
            check = true;
            return;
        }
        visited[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (ni < 0 || ni >= 5 || nj < 0 || nj >= 5 || visited[ni][nj] || arr[ni][nj] == -1)
                continue;

            dfs(ni, nj, cnt + 1, apple);
        }
        visited[i][j] = false;
    }
}