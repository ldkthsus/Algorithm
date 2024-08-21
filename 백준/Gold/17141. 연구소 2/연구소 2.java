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
	static int n, m, map[][], time, min = Integer.MAX_VALUE;
	static boolean visited[][];
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };
	static List<point> beuck, virus, empty;
	static point result[];
	static Queue<point> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		empty = new ArrayList<>();
		beuck = new ArrayList<>();
		virus = new ArrayList<>();
		result = new point[m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					beuck.add(new point(i, j));
				else if (map[i][j] == 2)
					virus.add(new point(i, j));
				else if (map[i][j] == 0)
					empty.add(new point(i, j));
			}
		}
		comb(0, 0);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	public static void comb(int start, int idx) {
		if (idx == m) {
			queue = new ArrayDeque<>();
			for (int i = 0; i < m; i++) {
				map[result[i].i][result[i].j] = 3;
				queue.offer(new point(result[i].i, result[i].j));
			}
			bfs();
			change();
			return;
		}
		for (int i = start; i < virus.size(); i++) {
			result[idx] = new point(virus.get(i).i, virus.get(i).j);
			comb(i + 1, idx + 1);
		}
	}

	public static void bfs() {
		visited = new boolean[n][n];
		time = 0;
		if (check()) {
			if (min > time) {
				min = time;
			}
		}

		naga: while (!queue.isEmpty()) {
			int size = queue.size();
			if (check()) {
				if (min > time) {
					min = time;
				}
				break naga;
			}
			for (int s = 0; s < size; s++) {
				point current = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nexti = current.i + di[d];
					int nextj = current.j + dj[d];

					if (nexti < 0 || nexti >= n || nextj < 0 || nextj >= n)
						continue;
					if (map[nexti][nextj] != 1 && !visited[nexti][nextj]) {
						visited[nexti][nextj] = true;
						queue.offer(new point(nexti, nextj));
						map[nexti][nextj] = 3;
					}
				}
			}
			time++;
		}

	}

	public static boolean check() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0 || map[i][j] == 2) {
					return false;
				}
			}
		}
		return true;
	}

	public static void change() {
		for (int k = 0; k < empty.size(); k++) {
			map[empty.get(k).i][empty.get(k).j] = 0;
		}
		for (int k = 0; k < beuck.size(); k++) {
			map[beuck.get(k).i][beuck.get(k).j] = 1;
		}
		for (int k = 0; k < virus.size(); k++) {
			map[virus.get(k).i][virus.get(k).j] = 2;
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