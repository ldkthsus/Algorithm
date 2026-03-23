import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();

		String str = br.readLine();
		String bomb = br.readLine();

		if (str.length() < bomb.length()) {
			System.out.println(str);
		} else {
			for (int i = 0; i < str.length(); i++) {
				stack.push(str.charAt(i));
				if (stack.size() >= bomb.length() && stack.peek() == bomb.charAt(bomb.length() - 1)) {
					boolean check = false;
					for (int j = 0; j < bomb.length(); j++) {
						if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
							check = true;
							break;
						}
					}

					if (!check) {
						for (int b = 0; b < bomb.length(); b++) {
							stack.pop();
						}
					}
				}
			}
			for(char word : stack) {
				sb.append(word);
			}
			if (sb.length() == 0) {
				System.out.println("FRULA");
			} else {
				System.out.println(sb);
			}
		}
	}
}