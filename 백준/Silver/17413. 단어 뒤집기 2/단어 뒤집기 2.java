import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        boolean check = false;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char word = str.charAt(i);

            if (word == '<') {
                check = true;
                if (!stack.isEmpty()) {
                    int size = stack.size();
                    for (int j = 0; j < size; j++) {
                        sb.append(stack.pop());
                    }
                }
                sb.append(word);
            } else if (word == '>') {
                check = false;
                sb.append(word);
            } else if (word == ' ') {
                if (check) {
                    sb.append(word);
                } else {
                    int size = stack.size();
                    for (int j = 0; j < size; j++) {
                        sb.append(stack.pop());
                    }
                    sb.append(word);
                }
            } else {
                if (check) {
                    sb.append(word);
                } else {
                    stack.push(word);
                }
            }
        }
        if (!stack.isEmpty()) {
            int size = stack.size();
            for (int j = 0; j < size; j++) {
                sb.append(stack.pop());
            }
        }
        System.out.println(sb);
    }
}
