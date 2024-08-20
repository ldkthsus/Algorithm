import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, order[], board[][], player[], score, max = Integer.MIN_VALUE, out,taja;
	static boolean selected[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		player = new int[10];
		order = new int[10];
		selected = new boolean[10];
		board = new int[N + 1][10];

		for (int i = 1; i <= 9; i++) {
			player[i] = i;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 9; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		perm(1);
		System.out.println(max);
	}

	public static void perm(int idx) {
		if (idx == 10) {
//			System.out.println(Arrays.toString(order));
//			System.out.println();
			play();
			out = 0;
			if (max < score)
				max = score;
			score = 0;
			taja = 1;
			return;
		}

		if (idx == 4) {
			order[4] = 1;
			idx++;
		}
		for (int i = 2; i <= 9; i++) {
			if (!selected[i]) {
				order[idx] = player[i];
				selected[i] = true;
				perm(idx + 1);
				selected[i] = false;
			}
		}
	}
	
	public static void play() {
		int base[] = new int[5];
		int i = 1;
		while (true) {
//			System.out.print(order[taja]+" ");
			if (out == 3) {
				i++;
				Arrays.fill(base, 0);
				out=0;
//				System.out.println(score);
				if (i == N + 1)
					break;
			}
			switch (board[i][order[taja]]) {
			case 0:
				out++;
				break;
			case 1:
				if (base[3] > 0) {
					base[4] = base[3];
					score++;
					base[3] = 0;
					if (base[2] > 0) {
						base[3] = base[2];
						base[2] = 0;
					}
					if (base[1] > 0) {
						base[2] = base[1];
						base[1] = 0;
					}
					base[1] = 1;
				} else if (base[2] > 0) {
					base[3] = base[2];
					base[2] = 0;
					if (base[1] > 0) {
						base[2] = base[1];
						base[1] = 0;
					}
					base[1] = 1;
				} else if (base[1] > 0) {
					base[2] = base[1];
					base[1] = 1;
				} 
				base[1] = 1;
				
				break;
			case 2:
				if (base[3] > 0) {
					base[4] = base[3];
					score++;
					base[3] = 0;
					if (base[2] > 0) {
						base[4] = base[2];
						score++;
						base[2] = 0;
					}
					if (base[1] > 0) {
						base[3] = base[1];
						base[1] = 0;
					} 
					base[2] = 1;
				} else if (base[2] > 0) {
					base[4] = base[2];
					score++;
					base[2] = 0;
					if (base[1] > 0) {
						base[3] = base[1];
						base[1] = 0;
					} 
					base[2] = 1;
				} else if (base[1] > 0) {
					base[3] = base[1];
					base[1] = 0;
					
				}
				base[2] = 1;
				break;
			case 3:
				if (base[3] > 0) {
					base[4] = base[3];
					score++;
					base[3] = 0;
					if (base[2] > 0) {
						base[4] = base[2];
						score++;
						base[2] = 0;
					}
					if (base[1] > 0) {
						base[4] = base[1];
						score++;
						base[1] = 0;
					}
					base[3] = 1;
				} else if (base[2] > 0) {
					base[4] = base[2];
					score++;
					base[2] = 0;
					if (base[1] > 0) {
						base[4] = base[1];
						score++;
						base[1] = 0;
					}
					base[3] = 1;
				} else if (base[1] > 0) {
					base[4] = base[1];
					score++;
					base[1] = 0;
					
				} 
				base[3] = 1;
				break;
			case 4:
				if (base[3] > 0 && base[2] > 0 && base[1] > 0) {
					score += 4;
				} else if ((base[3] > 0 && base[2] > 0) || base[3] > 0 && base[1] > 0) {
					score += 3;
				} else if (base[3] > 0)
					score += 2;
				else if (base[2] > 0 && base[1] > 0) {
					score += 3;
				} else if (base[2] > 0)
					score += 2;
				else if (base[1] > 0)
					score += 2;
				else
					score++;
				Arrays.fill(base,0);
				break;
			}
			taja = (taja + 1) % 10;
			if(taja==0)taja++;
			
		}
	}
}