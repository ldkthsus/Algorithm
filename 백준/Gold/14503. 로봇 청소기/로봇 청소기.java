import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, map[][], cnt, nexti, nextj;
	static int del[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static point ro;
	static boolean check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int roi = Integer.parseInt(st.nextToken());
		int roj = Integer.parseInt(st.nextToken());
		int direct = Integer.parseInt(st.nextToken());
		ro = new point(roi, roj, direct);

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		check = false;
		while (true) {
			clean(ro.i, ro.j);

			for (int d = 0; d < 4; d++) {
				nexti = ro.i + del[d][0];
				nextj = ro.j + del[d][1];

				if (boundary(nexti, nextj) && map[nexti][nextj] == 0) {
					check = true;
					break;
				}
			}
			if (check) {
				ro.d = (ro.d - 1);
				if (ro.d == -1)
					ro.d = 3;
				int afteri = ro.i + del[ro.d][0];
				int afterj = ro.j + del[ro.d][1];
				if (map[afteri][afterj] == 0) {
					ro.i = afteri;
					ro.j = afterj;
				}

			} else {
				int dir = (ro.d + 2) % 4;
				int afteri = ro.i + del[dir][0];
				int afterj = ro.j + del[dir][1];
				if (boundary(afteri, afterj) && map[afteri][afterj] != 1) {
					ro.i = afteri;
					ro.j = afterj;
				} else {
					break;
				}
			}
			check = false;
		}
		System.out.println(cnt);
	}

	public static boolean boundary(int i, int j) {
		if (i < 0 || i >= N || j < 0 || j >= M)
			return false;
		else
			return true;
	}

	public static void clean(int i, int j) {
		if (map[i][j] == 0) {
			map[i][j] = 2;
			cnt++;
		}
	}

	public static class point {
		int i, j, d;

		public point(int i, int j, int d) {
			this.i = i;
			this.j = j;
			this.d = d;
		}
	}
}