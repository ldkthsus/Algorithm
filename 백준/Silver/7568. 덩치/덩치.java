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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                if (arr[i].weight < arr[j].weight && arr[i].height < arr[j].height)
                    cnt++;
            }
            sb.append(cnt).append(" ");
        }
        System.out.println(sb);
    }

    public static class Point {
        int weight;
        int height;

        public Point(int w, int h) {
            this.weight = w;
            this.height = h;
        }
    }
}