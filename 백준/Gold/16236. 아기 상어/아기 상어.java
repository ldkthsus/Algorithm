import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, map[][], sharkeat, sharki, sharkj, ans, sharksize;
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };
	static boolean visited[][], iseat;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					sharki = i;
					sharkj = j;
					sharksize = 2;
					sharkeat = 0;
					map[i][j] = 0;
				}
			}
		}
		while (true) {
			if (!find(sharki, sharkj))
				break;
		}
		System.out.println(ans);
	}

	public static boolean find(int nowi, int nowj) {

		visited = new boolean[N][N];
		Queue<point> queue = new ArrayDeque<point>();
		queue.offer(new point(nowi, nowj));
		visited[nowi][nowj] = true;

		PriorityQueue<point> fish = new PriorityQueue<point>();
		boolean iseat = false;
		int dis = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				point current = queue.poll();

				if (map[current.i][current.j] != 0 && map[current.i][current.j] < sharksize) {
					fish.offer(current);
				}

				for (int d = 0; d < 4; d++) {
					int nexti = current.i + di[d];
					int nextj = current.j + dj[d];

					if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && !visited[nexti][nextj]
							&& sharksize >= map[nexti][nextj]) {
						queue.offer(new point(nexti, nextj));
						visited[nexti][nextj] = true;
					}
				}
			}

			if (!fish.isEmpty()) {
				point feed = fish.poll();
				sharki = feed.i;
				sharkj = feed.j;
				map[sharki][sharkj] = 0;
				sharkeat++;
				if (sharkeat == sharksize) {
					sharksize++;
					sharkeat = 0;
				}
				iseat = true;
				ans += dis;
				break;
			}
			dis++;
		}
		return iseat;
	}

	public static class point implements Comparable<point> {
		int i, j;

		public point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public int compareTo(point o) {
			if (this.i != o.i)
				return this.i - o.i;
			return this.j - o.j;
		}
	}
}