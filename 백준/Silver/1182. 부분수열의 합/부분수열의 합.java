import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int arr[], cnt, n, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        comb(0, 0);
        if (s == 0)
            System.out.println(cnt - 1);
        else System.out.println(cnt);

    }

    public static void comb(int start, int sum) {
        if (start == n) {
            if (sum == s)
                cnt++;
            return;
        }
        comb(start + 1, sum + arr[start]);
        comb(start + 1, sum);
    }
}