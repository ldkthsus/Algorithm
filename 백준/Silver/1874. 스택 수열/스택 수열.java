import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int idx = 0;
        int num = 1;

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        while (true) {
            if (idx == n) {
                break;
            }
            int target = arr[idx];
            if (stack.isEmpty()) {
                stack.push(num);
                sb.append("+").append("\n");
                num++;
            } else {
                if (stack.peek() == target) {
                    stack.pop();
                    sb.append("-").append("\n");
                    idx++;
                } else if (stack.peek() < target) {
                    stack.push(num);
                    sb.append("+").append("\n");
                    num++;
                } else {
                    int val = stack.pop();
                    if (target == val) {
                        sb.append("-").append("\n");
                        idx++;
                    } else {
                        sb = new StringBuilder();
                        sb.append("NO");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}