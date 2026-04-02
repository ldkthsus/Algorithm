import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean check = true;
        int number = 1;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }
        int idx = 0;
        while (true) {
            if (idx == n) {
                break;
            }
            if (stack.isEmpty()) {
                stack.push(number);
                number++;
                sb.append("+").append("\n");
            } else {
                int top = stack.peek();
                if (top == arr[idx]) {
                    stack.pop();
                    sb.append("-").append("\n");
                    idx++;
                } else if (top < arr[idx]) {
                    stack.push(number);
                    number++;
                    sb.append("+").append("\n");
                } else {
                    check = false;
                    break;
                }
            }
        }
        if (!check)
            System.out.println("NO");
        else System.out.println(sb);
    }
}