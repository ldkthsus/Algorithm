import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n, m, cha;
		int min = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int start = 0;
		int end = 0;

		while (end < n && start < n) {
			cha = arr[end] - arr[start];
			if (cha < m) {
				end++;
			} else if (cha >= m) {
				min = Math.min(min, cha);
				start++;
			}
		}
		System.out.println(min);
	}
}