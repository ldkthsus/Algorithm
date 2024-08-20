import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N, sum;
	static work 과제[];
	static Stack<work> stack = new Stack<work>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		과제 = new work[N];

		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			if (a == 1) {
				int b = sc.nextInt();
				int c = sc.nextInt();
				과제[i] = new work(b, c);
			}

			else if (a == 0) {
				int b = 0;
				int c = 0;
				과제[i] = new work(b, c);
			}
		}

		for (int i = 0; i < N; i++) {
			solve(과제[i].score, 과제[i].time);
//			System.out.println(stack);
		}
		System.out.println(sum);

	}

	public static void solve(int jeomsu, int shigan) {
		if (shigan > 0) {
			stack.add(new work(jeomsu, shigan));
		}
		if (!stack.isEmpty())
			stack.peek().time -= 1;
		if (!stack.isEmpty() && stack.peek().time == 0) {
			sum += stack.pop().score;
		}
	}

	public static class work {
		int score;
		int time;

		public work(int i, int j) {
			this.score = i;
			this.time = j;
		}

		@Override
		public String toString() {
			return "work [score=" + score + ", time=" + time + "]";
		}

	}

}