import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long dp[][] = new long[2][n];
        dp[0][0] = 0; //안쏨
        dp[1][0] = arr[0];

        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[1][i - 1];
            dp[1][i] = arr[i] + Math.min(dp[0][i - 1], dp[1][i - 1]);
        }
        System.out.println(Math.min(dp[0][n - 1], dp[1][n - 1]));
    }
}