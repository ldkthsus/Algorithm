import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                char now = str.charAt(i);

                if (stack.isEmpty()) {
                    stack.push(now);
                } else {
                    if (now == '(') {
                        stack.push(now);
                    } else {
                        if (stack.peek() == '(') {
                            stack.pop();
                        }
                    }
                }
            }

            if (stack.isEmpty()) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}