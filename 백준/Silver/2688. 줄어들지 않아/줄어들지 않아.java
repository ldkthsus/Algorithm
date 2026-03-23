import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        long dp[][] = new long[65][10];
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < 65; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }
        for (int t = 0; t < TC; t++) {
            int n = Integer.parseInt(br.readLine());
            long ans = 0;
            for (int i = 0; i <= 9; i++) {
                ans += dp[n][i];
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}