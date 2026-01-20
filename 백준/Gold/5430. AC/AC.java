import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			int n = Integer.parseInt(br.readLine());

			Deque<Integer> deque = new ArrayDeque<Integer>();
			st = new StringTokenizer(br.readLine(), "[],");
			for (int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}

			AC(str, deque);
		}
		System.out.println(sb);
	}

	public static void AC(String str, Deque<Integer> deque) {
		boolean change = false;
		boolean isError = false;
		naga: for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'R') {
				change = !change;
			} else if (str.charAt(i) == 'D') {
				if (deque.size() > 0 && !change) {
					deque.removeFirst();
				} else if (deque.size() > 0 && change) {
					deque.removeLast();
				} else if (deque.size() == 0) {
					isError = true;
					sb.append("error");
					sb.append("\n");
					break naga;
				}
			}
		}

		if (!isError && !change) {
			sb.append("[");
			int size = deque.size();
			if (!deque.isEmpty()) {
				sb.append(deque.pollFirst());
				for (int i = 0; i < size - 1; i++) {
					sb.append(",");
					sb.append(deque.pollFirst());
				}
			}
			sb.append("]");
			sb.append("\n");
		} else if (!isError && change) {
			sb.append("[");
			int size = deque.size();
			if (!deque.isEmpty()) {
				sb.append(deque.pollLast());
				for (int i = 0; i < size - 1; i++) {
					sb.append(",");
					sb.append(deque.pollLast());
				}
			}
			sb.append("]");
			sb.append("\n");
		}
	}
}