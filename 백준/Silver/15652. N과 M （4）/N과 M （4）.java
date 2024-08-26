import java.util.Scanner;

public class Main {
	static int N,M, result[], number[];
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		number = new int[N];
		result = new int [M];
		
		for(int i=0;i<N;i++) {
			number[i] = i+1;
		}
		
		중복조합(0, 0);
		System.out.println(sb.toString());
	}
	
	public static void 중복조합(int idx, int start) {
		if(idx==M) {
			for(int i=0;i<M;i++) {
				sb.append(result[i] + " ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=start;i<N;i++) {
			result[idx] = number[i];
			중복조합(idx+1, i);
		}
	}

}