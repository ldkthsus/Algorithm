import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n + 1]; //n을 1로 만들 때 연산을 사용하는 횟수의 최솟값
        int before[] = new int[n + 1]; // 연산을 사용했을 때 그 전의 값을 저장하는 배열

        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            before[i] = i - 1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                before[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                before[i] = i / 3;
            }
        }
        System.out.println(dp[n]);

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n + " ");
            n = before[n];
        }

        System.out.println(sb);

    }
}