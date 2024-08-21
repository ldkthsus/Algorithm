

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, cnt;
	static int arr[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1][N + 1];
		cnt = 0;

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(1, 1, 2);
		System.out.println(cnt);

	}

	public static void dfs(int state, int nowi, int nowj) {
		if (nowi == N || nowj == N) {
			if (nowi == N && nowj == N) {
				cnt++;
				return;
			}
		}

		switch (state) {
		case 1:
			if (nowj + 1 >= 1 && nowj + 1 < N + 1 && arr[nowi][nowj + 1] != 1) {
				dfs(1, nowi, nowj + 1);

			}
			if (nowi + 1 >= 1 && nowi + 1 < N + 1 && nowj + 1 >= 1 && nowj + 1 < N + 1 && arr[nowi + 1][nowj + 1] != 1
					&& arr[nowi][nowj + 1] != 1 && arr[nowi + 1][nowj] != 1) {
				dfs(3, nowi + 1, nowj + 1);

			}
			break;
		case 2:
			if (nowi + 1 >= 1 && nowi + 1 < N + 1 && nowj >= 1 && nowj < N + 1 && arr[nowi + 1][nowj] != 1) {
				dfs(2, nowi + 1, nowj);

			}
			if (nowi + 1 >= 1 && nowi + 1 < N + 1 && nowj + 1 >= 1 && nowj + 1 < N + 1 && arr[nowi + 1][nowj + 1] != 1
					&& arr[nowi][nowj + 1] != 1 && arr[nowi + 1][nowj] != 1) {
				dfs(3, nowi + 1, nowj + 1);

			}
			break;
		case 3:
			if (nowi >= 1 && nowi < N + 1 && nowj + 1 >= 1 && nowj + 1 < N + 1 && arr[nowi][nowj + 1] != 1) {

				dfs(1, nowi, nowj + 1);

			}

			if (nowi + 1 >= 1 && nowi + 1 < N + 1 && nowj >= 1 && nowj < N + 1 && arr[nowi + 1][nowj] != 1) {
				dfs(2, nowi + 1, nowj);

			}
			if (nowi + 1 >= 1 && nowi + 1 < N + 1 && nowj + 1 >= 1 && nowj + 1 < N + 1 && arr[nowi + 1][nowj + 1] != 1
					&& arr[nowi][nowj + 1] != 1 && arr[nowi + 1][nowj] != 1) {
				dfs(3, nowi + 1, nowj + 1);

			}
			break;
		}
	}

}
