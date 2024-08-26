import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N, M, result[];
	static List<Integer> list;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		list = new ArrayList<Integer>();
		result = new int[M];
		
		for(int i=0;i<N;i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		comb(0, 0);
		
		System.out.println(sb.toString());
	}
	
	public static void comb(int idx, int start) {
		if(idx == M) {
			for(int i=0;i<M;i++) {
				sb.append(result[i] + " ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i = start;i<N;i++) {
			result[idx] = list.get(i);
			comb(idx+1, i+1);
		}
	}

}