import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int arr[][], n;
    public static boolean check;
    public static int di[] = {0, 1}; //오른쪽, 아래
    public static int dj[] = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        if(check)
            System.out.println("HaruHaru");
        else System.out.println("Hing");
    }

    public static void bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0, 0));
        boolean visited[][] = new boolean[n][n];
        visited[0][0] = true;
        check = false;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                Point now = queue.poll();
                int jump = arr[now.i][now.j];

                for (int d = 0; d < 2; d++) {
                    int ni = now.i + di[d] * jump;
                    int nj = now.j + dj[d] * jump;

                    if (ni < 0 || ni >= n || nj < 0 || nj >= n || visited[ni][nj])
                        continue;

                    if (ni == n - 1 && nj == n - 1) {
                        check = true;
                        break;
                    }
                    queue.offer(new Point(ni, nj));
                    visited[ni][nj] = true;
                }
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