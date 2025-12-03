import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); //팀 개수
            int k = Integer.parseInt(st.nextToken()); //문제 개수
            int t = Integer.parseInt(st.nextToken()); //팀 id
            int m = Integer.parseInt(st.nextToken()); //로그 개수

            int arr[][] = new int[n + 1][k + 1];
            Point team[] = new Point[n];

            for (int i = 0; i < n; i++) {
                team[i] = new Point(i + 1, 0, 0, Integer.MAX_VALUE);
            }

            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());

                int id = Integer.parseInt(st.nextToken());
                int problem = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                if (arr[id][problem] < score) {
                    team[id - 1].sum -= arr[id][problem];
                    team[id - 1].sum += score;
                    arr[id][problem] = score;
                }
                team[id - 1].cnt++;
                team[id - 1].time = i;
            }
            Arrays.sort(team);
            for (int i = 0; i < n; i++) {
                if (team[i].id == t) {
                    sb.append(i + 1).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    public static class Point implements Comparable<Point> {
        int id;
        int sum;
        int cnt;
        int time;

        public Point(int i, int s, int c, int t) {
            this.id = i;
            this.sum = s;
            this.cnt = c;
            this.time = t;
        }

        @Override
        public int compareTo(Point o) {
            if (this.sum == o.sum) {
                if (this.cnt == o.cnt)
                    return this.time - o.time;
                else return this.cnt - o.cnt;
            } else return o.sum - this.sum;
        }
    }
}