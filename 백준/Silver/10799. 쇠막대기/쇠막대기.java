import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		int result = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '(')
				stack.push(i);
			else {
				if(stack.pop() == i-1) // 서로 인접한 경우.
					result+=stack.size();
				else // 아닌 경우
					result+=1;
			}
		}
		
		System.out.println(result);
		
		

	}
}