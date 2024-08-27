import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int sero, garo, map[], right, left, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());

		map = new int[garo];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < garo; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < garo; i++) {
			if (i == 0 || i == garo - 1)
				continue;
			check(i);
			if (left > map[i] && map[i] < right) {
				int temp = Math.min(left, right);
				int result = Math.abs(temp - map[i]);
				count += result;
			}
		}
		System.out.println(count);
	}

	public static void check(int nowi) {
		right = 0;
		left = 0;
		for (int i = 0; i < nowi; i++) {
			left = Math.max(left, map[i]);
		}
		for (int i = nowi + 1; i < garo; i++) {
			right = Math.max(right, map[i]);
		}
	}
}