import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        int temp = 1;
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (now == '(') {
                stack.push(now);
                temp *= 2;
            } else if (now == '[') {
                stack.push(now);
                temp *= 3;
            } else if (now == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    ans = 0;
                    break;
                } else if (str.charAt(i - 1) == '(') {
                    ans += temp;
                }
                stack.pop();
                temp /= 2;
            } else if (now == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    ans = 0;
                    break;
                } else if (str.charAt(i - 1) == '[') {
                    ans += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }
        if (!stack.isEmpty()) {
            ans = 0;
        }
        System.out.println(ans);
    }
}