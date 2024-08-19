import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		int K = sc.nextInt();

		int ball[] = new int[N + 1];
		ball[X] = 1;
		for (int i = 0; i < K; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			int temp = ball[a];
			ball[a] = ball[b];
			ball[b] = temp;
		}
		
		for(int i=0;i<=N;i++) {
			if(ball[i] == 1)
				System.out.println(i);
		}
	}

}