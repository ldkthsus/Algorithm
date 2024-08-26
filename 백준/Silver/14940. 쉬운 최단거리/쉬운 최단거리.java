import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, arr[][], result[][], starti, startj, count;
    static boolean[][] visited;
    static int di[] = {-1, 1, 0, 0};
    static int dj[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        result = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    starti = i;
                    startj = j;
                }
            }
        }
        bfs(starti, startj);
        check(visited);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int i, int j) {
        Queue<point> queue = new ArrayDeque<>();
        queue.add(new point(i, j));
        visited[i][j] = true;
        result[i][j] = 0;
        count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int s = 0; s < size; s++) {
                point cur = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nexti = cur.i + di[d];
                    int nextj = cur.j + dj[d];

                    if (nexti < 0 || nexti >= n || nextj < 0 || nextj >= m || visited[nexti][nextj] || arr[nexti][nextj] == 0) {
                        continue;
                    }
                    visited[nexti][nextj] = true;
                    queue.add(new point(nexti, nextj));
                    result[nexti][nextj] = count;
                }
            }
        }
    }

    public static void check(boolean visited[][]) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && arr[i][j] != 0) {
                    result[i][j] = -1;
                }
            }
        }
    }

    public static class point {
        int i, j;

        public point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}