
import java.util.Scanner;

public class Main {

	static int N, S, result[], num, arr[], count;
	

	public static void main(String[] args) {
		count=0;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		
		arr = new int[N];
		result = new int [N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		comb(0, 0);
		if(S == 0) {
			System.out.println(count-1);
			return;
		}
        System.out.println(count);

	}

	public static void comb(int idx, int sum) {
		
		if(idx == N) {
			if(sum==S)
				count++;
			return;
		}

		comb(idx+1, sum+arr[idx]);
		comb(idx+1, sum);
	}

}
