import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, village[][], chichi, chimin = Integer.MAX_VALUE, total, totalmin = Integer.MAX_VALUE;
	static List<point> home, chicken;
	static point hubo[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		village = new int[N][N];
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		hubo = new point[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				village[i][j] = Integer.parseInt(st.nextToken());
				if (village[i][j] == 1) {
					home.add(new point(i, j));
				} else if (village[i][j] == 2) {
					chicken.add(new point(i, j));
				}
			}
		}
		comb(0, 0);
		System.out.println(totalmin);

	}

	public static void comb(int start, int idx) {
		if (idx == M) {
			cal(hubo);
			return;
		}
		for (int i = start; i < chicken.size(); i++) {
			hubo[idx] = new point(chicken.get(i).i, chicken.get(i).j);
			comb(i + 1, idx + 1);
		}
	}

	public static void cal(point arr[]) {
		total = 0;
		for (int i = 0; i < home.size(); i++) {
			chimin = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				chichi = Math.abs(arr[j].i - home.get(i).i) + Math.abs(arr[j].j - home.get(i).j);
				if (chimin > chichi)
					chimin = chichi;
			}
			total += chimin;
		}
		if (totalmin > total)
			totalmin = total;
	}

	public static class point {
		int i, j;

		public point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}