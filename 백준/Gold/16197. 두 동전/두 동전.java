import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, count, result[], ans;
	static char map[][];
	static int dx[] = { -1, 1, 0, 0 }; // 아래, 위, 좌, 우
	static int dy[] = { 0, 0, -1, 1 };
	static boolean visited[][];
	static point coinone, cointwo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		map = new char[n][m];
		result = new int[10];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'o') {
					if (coinone == null) 
						coinone = new point(i, j);
					else
						cointwo = new point(i, j);
				}
			}
		}
		perm(0);
		System.out.println(ans==Integer.MAX_VALUE?-1:ans);
	}

	public static void perm(int cnt) {
		if (cnt == 10) {
			move(result);
			return;
		}
		for (int i = 0; i < 4; i++) {
			result[cnt] = i;
			
			perm(cnt + 1);
		}
	}

	public static void move(int arr[]) {
		point c1 = new point(coinone.i, coinone.j);
		point c2 = new point(cointwo.i, cointwo.j);
		for (int i = 0; i < 10; i++) {
			point nc1 = null;
			point nc2 = null;
			int nc1i = c1.i+dx[arr[i]];
			int nc1j = c1.j+dy[arr[i]];
			if(!(nc1i<0||nc1j<0||nc1i>=n||nc1j>=m)) {
				if(!(map[nc1i][nc1j]=='#')) {
					nc1 = new point(nc1i, nc1j);
				}else {
					nc1 = new point(c1.i,c1.j);
				}
			}
			int nc2i = c2.i+dx[arr[i]];
			int nc2j = c2.j+dy[arr[i]];
			if(!(nc2i<0||nc2j<0||nc2i>=n||nc2j>=m)) {
				if(!(map[nc2i][nc2j]=='#')) {
					nc2 = new point(nc2i, nc2j);
				}else {
					if(nc1!=null) {
						if(c2.i==nc1.i&&c2.j==nc1.j) {
							return;
						}
					}
					nc2 = new point(c2.i,c2.j);
				}
			}
			if(nc1==null||nc2==null) {
				if(nc1==null&&nc2==null) {
					return;
				}
				ans = Math.min(ans, i+1);
				return;
			}
			c1 = nc1;
			c2 = nc2;
		}
	}

	public static class point {
		int i, j;

		public point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}