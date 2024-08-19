
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, cnt, stage;
	static belt naegudo[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		naegudo = new belt[2 * N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			naegudo[i] = new belt(Integer.parseInt(st.nextToken()), false);
		}

		naga: while (true) {
			stage++;
			move(naegudo);
			for (int i = N; i >-1; i--) {
				
				if (i == N - 1) {
					naegudo[i].robot = false;
				}
				if (naegudo[i + 1].power > 0 && !naegudo[i + 1].robot && naegudo[i].robot) {
					naegudo[i + 1].power--;
					if (naegudo[i+1].power == 0) {
						cnt++;
					}
					if(i+1!=N-1)
					naegudo[i + 1].robot = true;
					naegudo[i].robot = false;
				}
				
			}
			
			if (naegudo[0].power > 0) {
				naegudo[0].robot = true;
				naegudo[0].power--;
				if (naegudo[0].power == 0) {
					cnt++;
					
				}
			}
			if (cnt >= K)
				break naga;
			
			
		}
		System.out.println(stage);
	}

	public static void move(belt arr[]) {
		belt temp = arr[2 * N - 1];
		for (int i = 2 * N - 2; i >= 0; i--) {
			arr[i + 1] = arr[i];
		}
		arr[0] = temp;
	}

	public static class belt {
		int power;
		boolean robot;

		public belt(int p, boolean r) {
			this.power = p;
			this.robot = r;
		}
	}
}