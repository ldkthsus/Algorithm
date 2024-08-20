import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, T, map[][], cnt, min = Integer.MAX_VALUE, kali, kalj, lasti, lastj, result = 0;
	static boolean visited[][];
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2) {
					kali = i;
					kalj = j;
				}
			}
		}

//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(map[i]));
//			System.out.println(kali + " " + kalj + " ");
//		}

		justbfs(0, 0);
		if (cnt > 0)
			if (min > cnt - 1) {
				min = cnt - 1;
			}
		cnt = 0;
		kalbfs(0, 0);
		if (cnt > 0)
			if (min > cnt) {
				min = cnt;
			}
		if (min <= T && cnt > 0)
			System.out.println(min);
		if (min > T || cnt < 0)
			System.out.println("Fail");
//		System.out.println(min);
	}

	public static void justbfs(int nowi, int nowj) {
		Queue<point> queue = new ArrayDeque<>();
		visited = new boolean[N][M];
		queue.offer(new point(nowi, nowj));
		visited[nowi][nowj] = true;

		naga: while (!queue.isEmpty()) {
			int size = queue.size();
//			System.out.println(size);
			for (int s = 0; s < size; s++) {
				point current = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nexti = current.i + di[d];
					int nextj = current.j + dj[d];
					if (nexti >= 0 & nexti < N && nextj >= 0 && nextj < M && !visited[nexti][nextj]
							&& map[nexti][nextj] == 0) {
						queue.offer(new point(nexti, nextj));
						visited[nexti][nextj] = true;

						if (nexti == N - 1 && nextj == M - 1) {
							lasti = nexti;
							lastj = nextj;
							cnt++;
							cnt++;
							break naga;
						}
					}
				}
			}
//			for (int f = 0; f < N; f++) {
//				System.out.println(Arrays.toString(visited[f]));
//			}
			cnt++;
//			System.out.println(cnt);
		}
//		System.out.println(lasti + " " + lastj);
//		for(int f=0;f<N;f++) {
//			System.out.println(Arrays.toString(visited[f]));
//		}
		if (lasti != N - 1 || lastj != M - 1)
			cnt = -1;
//		System.out.println("1" + " " + cnt);
//		System.out.println("Fail");
//		System.out.println(cnt - 1);
	}

	public static void kalbfs(int nowi, int nowj) {
		Queue<point> queue = new ArrayDeque<>();
		visited = new boolean[N][M];
		queue.offer(new point(nowi, nowj));
		visited[nowi][nowj] = true;

		naga: while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				point current = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nexti = current.i + di[d];
					int nextj = current.j + dj[d];
					if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && !visited[nexti][nextj]) {
						if (map[nexti][nextj] == 2) {
							result = Math.abs((N - 1 - kali) + (M - 1 - kalj) + 1);
							cnt += result;
							break naga;
						} else if (map[nexti][nextj] == 0) {
							queue.offer(new point(nexti, nextj));
							visited[nexti][nextj] = true;
							lasti = nexti;
							lastj = nextj;
						}
					}
				}
			}
			cnt++;
		}
//		for (int f = 0; f < N; f++) {
//			System.out.println(Arrays.toString(visited[f]));
//		}
//		System.out.println(lasti + " " + lastj);
		if (result <= 0)
			cnt = -1;
//		System.out.println("2" + " " + cnt);
//		System.out.println("Fail");
//		System.out.println(cnt);
	}

	public static class point {
		int i, j;

		public point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

}