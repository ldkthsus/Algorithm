import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, map[][], cnt, max = Integer.MIN_VALUE, hap;
	static boolean visited[][], select[];
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };
	static List<point> list, virus, beuck;
	static point result[];
	static Queue<point> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		result = new point[3];
		virus = new ArrayList<>();
		list = new ArrayList<>();
		beuck = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					list.add(new point(i, j));
				} else if (map[i][j] == 2) {
					virus.add(new point(i, j));
				} else if (map[i][j] == 1) {
					beuck.add(new point(i, j));
				}
			}
		}
		comb(0, 0);
		System.out.println(max);
	}

	public static void comb(int start, int idx) {
		if (idx == 3) {
			for (int i = 0; i < 3; i++) {
				map[result[i].i][result[i].j] = 1;
			}
			cnt = 0;
			bfs();
			hap = N * M - (cnt + virus.size() + 3 + beuck.size());
			if (max < hap)
				max = hap;
			for (int i = 0; i < 3; i++) {
				map[result[i].i][result[i].j] = 0;
			}
			return;
		}
		for (int i = start; i < list.size(); i++) {
			result[idx] = new point(list.get(i).i, list.get(i).j);
			comb(i + 1, idx + 1);
		}
	}

	public static void bfs() {
		queue = new ArrayDeque<>();
		visited = new boolean[N][M];
		for (int i = 0; i < virus.size(); i++) {
			queue.offer(new point(virus.get(i).i, virus.get(i).j));
			visited[virus.get(i).i][virus.get(i).j] = true;
		}
		while (!queue.isEmpty()) {
			point current = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nexti = current.i + di[d];
				int nextj = current.j + dj[d];

				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && !visited[nexti][nextj]
						&& map[nexti][nextj] == 0) {
					queue.offer(new point(nexti, nextj));
					visited[nexti][nextj] = true;
					cnt++;
				}
			}
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