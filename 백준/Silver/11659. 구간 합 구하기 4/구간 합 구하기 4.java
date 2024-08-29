import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int dp[] = new int[n + 1];
		int arr[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		dp[1] = arr[1];

		for (int i = 2; i <= n; i++) {
			dp[i] = arr[i] + dp[i - 1];
		}
//		for(int i=0;i<=n;i++) {
//			System.out.println(dp[i]);
//		}
//		System.out.println(Arrays.toString(dp));
		int result = 0;

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			result = dp[b] - dp[a-1];
			System.out.println(result);
		}

	}

}