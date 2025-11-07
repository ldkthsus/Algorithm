import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < n; t++) {
            Stack<Character> stack = new Stack<>();
            Stack<Character> cur = new Stack<>();

            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                char word = str.charAt(i);

                if (word == '<') {
                    if (stack.isEmpty())
                        continue;
                    char now = stack.pop();
                    cur.push(now);
                } else if (word == '>') {
                    if (!cur.isEmpty()) {
                        stack.push(cur.pop());
                    }
                } else if (word == '-') {
                    if (stack.isEmpty())
                        continue;
                    stack.pop();
                } else {
                    stack.push(word);
                }
            }

            if (!cur.isEmpty()) {
                int size = cur.size();
                for (int i = 0; i < size; i++) {
                    stack.push(cur.pop());
                }
            }

            int size = stack.size();
            StringBuilder temp = new StringBuilder();

            for (int i = 0; i < size; i++) {
                temp.append(stack.pop());
            }
            temp.reverse();
            sb.append(temp + "\n");
        }
        System.out.println(sb);
    }
}