import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean check = true;

            for (int j = 0; j < str.length(); j++) {
                char now = str.charAt(j);
                if (now == ')') {
                    if (stack.isEmpty()) {
                        sb.append("NO").append("\n");
                        check = false;
                        break;
                    } else stack.pop();
                } else stack.push(')');
            }
            if (check) {
                if (!stack.isEmpty()) {
                    sb.append("NO").append("\n");
                } else sb.append("YES").append("\n");
            }
        }
        System.out.println(sb);
    }
}