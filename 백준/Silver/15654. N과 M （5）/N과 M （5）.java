import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N, M, result[];
	static StringBuilder sb;
	static boolean used[];
	static List <Integer> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		sb = new StringBuilder();
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		
		used = new boolean [N];
		result = new int [M];
		list = new ArrayList<Integer>();
		
		for(int i=0;i<N;i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		
		perm(0);
		System.out.println(sb.toString());
	}
	
	public static void perm(int idx) {
		if(idx == M) {
			for(int i=0;i<M;i++) {
				sb.append(result[i] + " ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!used[i]) {
				result[idx] = list.get(i);
				used[i] = true;
				perm(idx+1);
				used[i] = false;
			}
		}
	}

}