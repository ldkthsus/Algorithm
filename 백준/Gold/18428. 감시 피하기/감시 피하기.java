import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static String ans;
	static char tong[][];
	static int di[] = { 0, 0, -1, 1 };
	static int dj[] = { -1, 1, 0, 0 };
	static List<point> empty, teacher;
	static point result[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		tong = new char[n][n];
		empty = new ArrayList<>();
		result = new point[3];
		teacher = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				tong[i][j] = st.nextToken().charAt(0);
				if (tong[i][j] == 'X') {
					empty.add(new point(i, j));
				} else if (tong[i][j] == 'T') {
					teacher.add(new point(i, j));
				}
			}
		}
		comb(0, 0);
		if (ans != "NO")
			System.out.println("YES");
		else
			System.out.println(ans);
	}

	public static void comb(int idx, int start) {
		if (idx == 3) {
			point one = new point(result[0].i, result[0].j);
			point two = new point(result[1].i, result[1].j);
			point three = new point(result[2].i, result[2].j);

			for (int i = 0; i < 3; i++) {
				tong[result[i].i][result[i].j] = 'O';
			}
			gamsi();
			tong[one.i][one.j] = 'X';
			tong[two.i][two.j] = 'X';
			tong[three.i][three.j] = 'X';

			return;
		}
		for (int i = start; i < empty.size(); i++) {
			result[idx] = new point(empty.get(i).i, empty.get(i).j);
			comb(idx + 1, i + 1);
		}
	}

	public static void gamsi() {
		naga: for (int i = 0; i < teacher.size(); i++) {
			for (int d = 0; d < 4; d++) {
				int l = 1;
				while (true) {
					
					int nexti = teacher.get(i).i + di[d] * l;
					int nextj = teacher.get(i).j + dj[d] * l;
					
					if (nexti >= n || nextj >= n || nexti < 0 || nextj < 0 || tong[nexti][nextj] == 'O') {
						break;
					}
					if (tong[nexti][nextj] == 'S') {
						ans = "NO";
						break naga;
					}
					l++;
				}
			}
			if(i==teacher.size()-1) {
				System.out.println("YES");
				System.exit(0);
			}
		}
	}

	public static class point {
		int i, j;

		public point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "point [i=" + i + ", j=" + j + "]";
		}
	}
}