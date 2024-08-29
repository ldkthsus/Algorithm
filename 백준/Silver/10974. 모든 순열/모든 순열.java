
import java.util.Scanner;



public class Main {
	
	static boolean used[];
	static int result[], N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		 N = sc.nextInt();
		
		used = new boolean[N+1];
		result = new int [N+1];
		
		perm(0);
		
	}
	
	public static void perm(int idx) {
		
		if(idx==N) {
			for(int i=0;i<N;i++) {
				System.out.print(result[i] + " ");
				
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=N;i++) {
			if(!used[i]) {
				used[i] = true;
				result[idx] = i;
				perm(idx+1);
				used[i] = false;
				
			}
		}
	}
	

}
