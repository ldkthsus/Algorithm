import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        int cnt = TC;

        for (int t = 0; t < TC; t++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                char word = str.charAt(i);
                if(stack.isEmpty()){
                    stack.push(word);
                }
                else{
                    if(word == stack.peek()){
                        stack.pop();
                    }
                    else{
                        stack.push(word);
                    }
                }
            }
            if(!stack.isEmpty())
                cnt--;
        }
        System.out.println(cnt);
    }
}