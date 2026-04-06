import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans[] = new int[n];
        int idx = n - 1;
        Stack<Integer> stack = new Stack<>();
        while (true) {
            if (idx == -1) {
                break;
            }
            if (stack.isEmpty()) {
                stack.push(idx);
                idx--;
            } else {
                int tower = arr[idx];
                int top = stack.peek();
                if (arr[top] <= tower) {
                    ans[top] = idx + 1;
                    stack.pop();
                } else {
                    stack.push(idx);
                    idx--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}