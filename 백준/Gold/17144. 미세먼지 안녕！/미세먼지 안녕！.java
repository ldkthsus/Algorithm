import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, T, result, room[][], temp[][];
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };
	static boolean visited[][];
	static point airhead, airtail;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		room = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if (room[i][j] == -1 && airhead == null) {
					airhead = new point(i, j);
					room[i][j] = 0;
				} else if (room[i][j] == -1 && airhead != null) {
					airtail = new point(i, j);
					room[i][j] = 0;
				}
			}
		}

		for (int t = 1; t <= T; t++) {
			temp = new int[R][C];
			spread();

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					room[i][j] += temp[i][j];
				}
			}
			banwind(airhead.i, airhead.j);
			wind(airtail.i, airtail.j);
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] > 0)
					result += room[i][j];
			}
		}
		System.out.println(result);
	}

	public static void spread() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int amount = 0;
				if (i == airhead.i && j == airhead.j)
					continue;
				if (i == airtail.i && j == airtail.j)
					continue;

				if (room[i][j] >= 5) {
					amount = room[i][j] / 5;
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int nexti = i + di[d];
						int nextj = j + dj[d];

						if (nexti < 0 || nexti >= R || nextj < 0 || nextj >= C)
							continue;
						if (nexti == airhead.i && nextj == airhead.j)
							continue;
						if (nexti == airtail.i && nextj == airtail.j)
							continue;

						temp[nexti][nextj] += amount;
						cnt++;
					}
					room[i][j] -= amount * cnt;
				}
			}
		}
	}

	public static void banwind(int headi, int headj) {
		for (int i = headi; i > 0; i--) {
			room[i][0] = room[i - 1][0];
		}
		for (int j = 0; j <= C - 2; j++) {
			room[0][j] = room[0][j + 1];
		}
		for (int i = 0; i <= headi - 1; i++) {
			room[i][C - 1] = room[i + 1][C - 1];
		}
		for (int j = C - 2; j >= 0; j--) {
			room[headi][j + 1] = room[headi][j];
		}
		room[airhead.i][airhead.j] = 0;
		room[airhead.i][airhead.j + 1] = 0;
	}

	public static void wind(int taili, int tailj) {
		for (int i = taili; i <= R - 2; i++) {
			room[i][0] = room[i + 1][0];
		}
		for (int j = tailj; j <= C - 2; j++) {
			room[R - 1][j] = room[R - 1][j + 1];
		}
		for (int i = R - 2; i >= taili - 1; i--) {
			room[i + 1][C - 1] = room[i][C - 1];
		}
		for (int j = C - 2; j >= 0; j--) {
			room[taili][j + 1] = room[taili][j];
		}
		room[airtail.i][airtail.j] = 0;
		room[airtail.i][airtail.j + 1] = 0;
	}

	public static class point {
		int i, j;

		public point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}