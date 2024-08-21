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
	static int n, m, map[][], min = Integer.MAX_VALUE, time, emptySize;
	static boolean visited[][];
	static int di[] = { 1, -1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };
	static List<Point> virusList, emptyList, beocklist;
	static Point result[];
	static Queue<Point> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		virusList = new ArrayList<>();
		result = new Point[m];
		emptyList = new ArrayList<>();
		beocklist = new ArrayList<>();
		queue = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					emptyList.add(new Point(i, j));
				} else if (map[i][j] == 1) {
					beocklist.add(new Point(i, j));
				} else if (map[i][j] == 2) {
					virusList.add(new Point(i, j));
				}
			}
		}
		if (count()) {
			System.out.println(0);
			System.exit(0);
		}
		comb(0, 0);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else if (min > 0)
			System.out.println(min);
	}

	public static void comb(int idx, int start) {
		if (idx == m) {
			queue.clear();
			for (int i = 0; i < m; i++) {
				map[result[i].i][result[i].j] = 3;
				queue.offer(new Point(result[i].i, result[i].j));
			}
			emptySize = emptyList.size();
			bfs();
			if (count()) {
				min = Math.min(min, time);
			}
			change();
			return;

		}
		for (int i = start; i < virusList.size(); i++) {
			result[idx] = new Point(virusList.get(i).i, virusList.get(i).j);
			comb(idx + 1, i + 1);
		}
	}

	public static void bfs() {
		visited = new boolean[n][n];
		time = 0;

		naga: while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point current = queue.poll();
				visited[current.i][current.j] = true;

				for (int d = 0; d < 4; d++) {
					int nexti = current.i + di[d];
					int nextj = current.j + dj[d];

					if (nexti < 0 || nexti >= n || nextj < 0 || nextj >= n)
						continue;
					if (!visited[nexti][nextj] && map[nexti][nextj] == 0) {
						map[nexti][nextj] = 3;
						queue.offer(new Point(nexti, nextj));
						emptySize -= 1;
						if (emptySize == 0) {
							time++;
							break naga;
						}
					}
					if (!visited[nexti][nextj] && map[nexti][nextj] == 2) {
						map[nexti][nextj] = 3;
						queue.offer(new Point(nexti, nextj));
					}
				}
			}
			time++;
		}
	}

	public static boolean count() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	public static void change() {
		for (int i = 0; i < virusList.size(); i++) {
			map[virusList.get(i).i][virusList.get(i).j] = 2;
		}
		for (int i = 0; i < emptyList.size(); i++) {
			map[emptyList.get(i).i][emptyList.get(i).j] = 0;
		}
		for (int i = 0; i < beocklist.size(); i++) {
			map[beocklist.get(i).i][beocklist.get(i).j] = 1;
		}
	}

	public static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}