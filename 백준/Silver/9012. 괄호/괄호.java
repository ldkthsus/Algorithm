import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int t = 0; t < tc; t++){
            String str = br.readLine();

            Stack<Character> stack = new Stack<>();
            boolean check = true;
            for(int i = 0; i < str.length(); i++){
                if(stack.isEmpty()){
                    if(str.charAt(i) == ')'){
                        check = false;
                        break;
                    }
                    stack.push(str.charAt(i));
                }
                else{
                    char word = str.charAt(i);
                    if(word == '(')
                        stack.push(word);
                    else
                        stack.pop();
                }
            }
            if(!stack.isEmpty() || !check)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}