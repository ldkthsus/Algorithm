import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static Point map[][];
    public static int di[] = {-1, 1, 0, 0};
    public static int dj[] = {0, 0, -1, 1};
    public static int r, c, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new Point[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                char now = str.charAt(j);

                if (now == '.') {
                    map[i][j] = new Point(now, -1);
                } else {
                    map[i][j] = new Point(now, 1);
                }
            }
        }
        int second = 1;
        boolean visited[][] = new boolean[r][c];

        while (true) {
            second++;
            if (second == n + 1) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        sb.append(map[i][j].state);
                    }
                    sb.append("\n");
                }
                System.out.println(sb);
                break;
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (!visited[i][j] && map[i][j].state == '.') {
                        map[i][j].state = 'O';
                        map[i][j].time++;
                    } else if (map[i][j].state == 'O') {
                        map[i][j].time++;
                        if (map[i][j].time == 3) {
                            for (int d = 0; d < 4; d++) {
                                int ni = i + di[d];
                                int nj = j + dj[d];

                                if (ni < 0 || ni >= r || nj < 0 || nj >= c)
                                    continue;
                                if (map[ni][nj].state == 'O' && map[ni][nj].time != 2) {
                                    map[ni][nj].state = '.';
                                    map[ni][nj].time = -1;
                                    visited[ni][nj] = true;
                                }
                            }
                            map[i][j].time = -1;
                            map[i][j].state = '.';
                            visited[i][j] = true;
                        }
                    }
                }
            }
            visited = new boolean[r][c];
        }
    }

    public static class Point {
        char state;
        int time;


        public Point(char s, int t) {
            this.state = s;
            this.time = t;
        }
    }
}