import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                stack.pop();
            }
            else{
                stack.push(num);
            }
        }
        int size = stack.size();
        for(int i = 0; i < size; i++){
            sum = sum + stack.pop();
        }
        System.out.println(sum);
    }
}