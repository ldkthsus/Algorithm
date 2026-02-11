import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[101][101];
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int li = Integer.parseInt(st.nextToken());
            int lj = Integer.parseInt(st.nextToken());
            int ri = Integer.parseInt(st.nextToken());
            int rj = Integer.parseInt(st.nextToken());

            paint(li, lj, ri, rj);
        }
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if (arr[i][j] > m)
                    cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void paint(int si, int sj, int ei, int ej) {
        for (int i = si; i <= ei; i++) {
            for (int j = sj; j <= ej; j++) {
                arr[i][j]++;
            }
        }
    }
}