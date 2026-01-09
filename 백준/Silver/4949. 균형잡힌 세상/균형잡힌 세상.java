import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals(".")) {
                break;
            } else {
                Stack<Character> stack = new Stack<>();
                boolean check = true;
                for (int i = 0; i < str.length(); i++) {
                    char now = str.charAt(i);
                    if (now == '(' || now == '[')
                        stack.push(now);
                    else if (now == ')' || now == ']') {
                        if (now == ')') {
                            if (!stack.isEmpty()) {
                                if (stack.peek() == '(') {
                                    stack.pop();
                                } else {
                                    sb.append("no").append("\n");
                                    check = false;
                                    break;
                                }
                            } else {
                                sb.append("no").append("\n");
                                check = false;
                                break;
                            }
                        } else {
                            if (!stack.isEmpty()) {
                                if (stack.peek() == '[') {
                                    stack.pop();
                                } else {
                                    sb.append("no").append("\n");
                                    check = false;
                                    break;
                                }
                            } else {
                                sb.append("no").append("\n");
                                check = false;
                                break;
                            }
                        }

                    }
                }
                if (check) {
                    if (stack.isEmpty())
                        sb.append("yes").append("\n");
                    else sb.append("no").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}