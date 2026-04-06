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
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int ans[] = new int[n];
        while (true) {
            if(idx == n){
                break;
            }
            if(stack.isEmpty()){
                stack.push(idx);
                idx++;
            }
            else{
                int num = arr[idx];
                int top = stack.peek();
                if(arr[top] < num){
                    ans[top] = num;
                    stack.pop();
                }else if(arr[top] >= num){
                    stack.push(idx);
                    idx++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(ans[i] == 0){
                sb.append(-1).append(" ");
            }else{
                sb.append(ans[i]).append(" ");
            }
        }
        System.out.println(sb);
    }
}