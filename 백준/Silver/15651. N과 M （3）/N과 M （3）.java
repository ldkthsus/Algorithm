import java.util.Scanner;

public class Main {
	static int N, M, number[], result[];

	static StringBuilder sb ;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		
		sb = new StringBuilder();
		number = new int [N];
		result = new int [M];
		
		for(int i=0;i<N;i++) {
			number[i] = i+1;
		}
		
		중복순열(0);
		System.out.println(sb.toString());
	}
	
	public static void 중복순열(int cnt) {
		if(cnt == M) {
			for(int i=0;i<M;i++) {
			sb.append(result[i] + " ");
			}
			sb.append('\n'); 
			return;
		}
		
		for(int i=0;i<N;i++) {
			result[cnt] = number[i];
			중복순열(cnt+1);
		}
	}
}