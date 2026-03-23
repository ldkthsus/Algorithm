

import java.util.Scanner;

public class Main {
	static int map[][] = new int [30][30];
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<T;i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
		sb.append(comb(m, n)).append('\n');
		
		}
		
		System.out.println(sb);
		
	}
	
	public static int comb(int n, int r) {
		if(map[n][r] > 0)
			return map[n][r];
		if(n==r || r==0) {
			return map[n][r] =1;
		}
		
		return map[n][r] = comb(n-1, r-1) + comb(n-1, r);
		
	}

}
