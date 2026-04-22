import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Point arr[] = new Point[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        boolean paper[][] = new boolean[101][101];
        for (int a = 0; a < n; a++) {
            int y = arr[a].down;
            int x = arr[a].left;
            for (int i = 100 - x - 10; i < 100 - x; i++) {
                for (int j = y; j < y + 10; j++) {
                    paper[i][j] = true;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (paper[i][j])
                    ans++;
            }
        }
        System.out.println(ans);
    }

    public static class Point {
        int left;
        int down;

        public Point(int l, int d) {
            this.left = l;
            this.down = d;
        }
    }
}