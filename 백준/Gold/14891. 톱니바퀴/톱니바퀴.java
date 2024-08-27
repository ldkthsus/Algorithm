import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int A[], B[], C[], D[], K, score, number, bang;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = new int[8];
		B = new int[8];
		C = new int[8];
		D = new int[8];
		char[] c;
		c = sc.nextLine().toCharArray();
		for (int i = 0; i < 8; i++) {
			A[i] = c[i] - '0';
		}
		c = sc.nextLine().toCharArray();
		for (int i = 0; i < 8; i++) {
			B[i] = c[i] - '0';
		}
		c = sc.nextLine().toCharArray();
		for (int i = 0; i < 8; i++) {
			C[i] = c[i] - '0';
		}
		c = sc.nextLine().toCharArray();
		for (int i = 0; i < 8; i++) {
			D[i] = c[i] - '0';
		}

		K = sc.nextInt();

		for (int j = 0; j < K; j++) {
			number = sc.nextInt();
			bang = sc.nextInt();
//end input

			if (number == 1) {
				if (bang > 0) {
					if (A[2] != B[6]) {
						if (B[2] != C[6] && C[2] != D[6]) {
							clock(A);
							banclock(B);
							clock(C);
							banclock(D);
						} else if (B[2] != C[6] && C[2] == D[6]) {
							clock(A);
							banclock(B);
							clock(C);
						} else if (B[2] == C[6]) {
							clock(A);
							banclock(B);
						}
					}
					else if(A[2] == B[6])
						clock(A);
				} else {
					if (A[2] != B[6]) {

						if (B[2] != C[6] && C[2] != D[6]) {
							banclock(A);
							clock(B);
							banclock(C);
							clock(D);
						} else if (B[2] != C[6] && C[2] == D[6]) {
							banclock(A);
							clock(B);
							banclock(C);
						} else if (B[2] == C[6]) {
							banclock(A);
							clock(B);
						}
					}
					else if(A[2] == B[6])
						banclock(A);
					
				}

			} else if (number == 2) {

				if (bang > 0) {
					if (A[2] != B[6] || B[2] != C[6]) {

						if (A[2] != B[6] && B[2] != C[6] && C[2] != D[6]) {
							clock(B);
							banclock(A);
							banclock(C);
							clock(D);
						} else if (A[2] != B[6] && B[2] != C[6] && C[2] == D[6]) {
							banclock(A);
							clock(B);
							banclock(C);
						} else if (A[2] != B[6] && B[2] == C[6]) {
							clock(B);
							banclock(A);
						} else if (A[2] == B[6] && B[2] != C[6] && C[2] != D[6]) {
							clock(B);
							banclock(C);
							clock(D);
						} else if (A[2] == B[6] && B[2] != C[6] && C[2] == D[6]) {
							clock(B);
							banclock(C);
						}
					}
					else if(B[6] == A[2]&&B[2]==C[6] )
						clock(B);
				} else {
					if (A[2] != B[6] || B[2] != C[6]) {

						if (A[2] != B[6] && B[2] != C[6] && C[2] != D[6]) {
							banclock(B);
							clock(A);
							clock(C);
							banclock(D);
						} else if (A[2] != B[6] && B[2] != C[6] && C[2] == D[6]) {
							clock(A);
							banclock(B);
							clock(C);
						} else if (A[2] != B[6] && B[2] == C[6]) {
							banclock(B);
							clock(A);
						} else if (A[2] == B[6] && B[2] != C[6] && C[2] != D[6]) {
							banclock(B);
							clock(C);
							banclock(D);
						} else if (A[2] == B[6] && B[2] != C[6] && C[2] == D[6]) {
							banclock(B);
							clock(C);
						}
					}
					else if(B[6] == A[2]&&B[2]==C[6])
						banclock(B);
				}

			} else if (number == 3) {
				if (bang > 0) {
					if (C[6] != B[2] || C[2] != D[6]) {

						if (A[2] != B[6] && B[2] != C[6] && C[2] != D[6]) {
							clock(C);
							clock(A);
							banclock(B);
							banclock(D);
						} else if (C[6] != B[2] && C[2] != D[6] && B[6] == A[2]) {
							banclock(D);
							clock(C);
							banclock(B);
						} else if (C[2] != D[6] && C[6] == B[2]) {
							clock(C);
							banclock(D);
						} else if (C[2] == D[6] && C[6] != B[2] && B[6] != A[2]) {
							clock(C);
							banclock(B);
							clock(A);
						} else if (C[2] == D[6] && C[6] != B[2] && B[6] == A[2]) {
							clock(C);
							banclock(B);
						}
					}
					else if(C[6]==B[2] && C[2] == D[6])
						clock(C);
				} else {
					if (C[6] != B[2] || C[2] != D[6]) {

						if (A[2] != B[6] && B[2] != C[6] && C[2] != D[6]) {
							banclock(C);
							banclock(A);
							clock(B);
							clock(D);
						} else if (C[6] != B[2] && C[2] != D[6] && B[6] == A[2]) {
							clock(D);
							banclock(C);
							clock(B);
						} else if (C[2] != D[6] && C[6] == B[2]) {
							banclock(C);
							clock(D);
						} else if (C[2] == D[6] && C[6] != B[2] && B[6] != A[2]) {
							banclock(C);
							clock(B);
							banclock(A);
						} else if (C[2] == D[6] && C[6] != B[2] && B[6] == A[2]) {
							banclock(C);
							clock(B);
						}
					}
					else if(C[6]==B[2] && C[2] == D[6])
						banclock(C);
				}

			} else if (number == 4) {
				if (bang > 0) {
					if (D[6] != C[2]) {

						if (A[2] != B[6] && B[2] != C[6]) {
							banclock(C);
							banclock(A);
							clock(B);
							clock(D);
						} else if ( C[6] != B[2] && B[6] == A[2]) {
							clock(D);
							banclock(C);
							clock(B);
						} else if (C[6] == B[2]) {
							banclock(C);
							clock(D);
						}
					}
					else if(D[6] == C[2])
						clock(D);
				} else {
					if (D[6] != C[2]) {

						if (A[2] != B[6] && B[2] != C[6] && C[2] != D[6]) {
							clock(C);
							clock(A);
							banclock(B);
							banclock(D);
						} else if (D[6] != C[2] && C[6] != B[2] && B[6] == A[2]) {
							banclock(D);
							clock(C);
							banclock(B);
						} else if (C[6] == B[2]) {
							clock(C);
							banclock(D);
						}
					}
					else if(D[6] == C[2])
						banclock(D);
				}

			}
	
			if (j == K - 1) {
				if (A[0] == 1) {
					score += 1;
				}
				if (B[0] == 1) {
					score += 2;
				}
				if (C[0] == 1) {
					score += 4;
				}
				if (D[0] == 1) {
					score += 8;
				}
			}
		}

		System.out.println(score);

	}

	public static void clock(int arr[]) {
		int temp = arr[7];
		for (int i = 7; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = temp;

	}

	public static void banclock(int arr[]) {
		int temp = arr[0];
		for (int i = 0; i < 7; i++) {
			arr[i] = arr[i + 1];
		}
		arr[7] = temp;
	}

}