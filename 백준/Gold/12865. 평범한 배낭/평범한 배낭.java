import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K, dp[][];
	static pair mulpum[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		mulpum = new pair[N + 1];
		dp = new int[N + 1][K + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			mulpum[i] = new pair(weight, value);
		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < K + 1; j++) {
				if (mulpum[i].kg > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(mulpum[i].val + dp[i - 1][j - mulpum[i].kg], dp[i - 1][j]);
				}
			}
		}
		System.out.println(dp[N][K]);

	}

	public static class pair {
		int val, kg;

		public pair(int k, int v) {
			this.kg = k;
			this.val = v;
		}
	}

}