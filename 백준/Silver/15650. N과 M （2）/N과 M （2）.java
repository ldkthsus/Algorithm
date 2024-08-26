import java.util.Scanner;

public class Main {

	static int N, M, number[], result[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N =sc.nextInt();
		M= sc.nextInt();
		
		number = new int [N];
		result = new int [M];
		
		for(int i=00;i<N;i++) {
			number[i] = i+1;
		}
		
		comb(0, 0);
	}
	
	public static void comb(int start, int idx) {
		if(idx==M) {
			for(int i=0;i<M;i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i<N;i++) {
			result[idx] = number[i];
			comb(i+1, idx+1);
		}
	}
}