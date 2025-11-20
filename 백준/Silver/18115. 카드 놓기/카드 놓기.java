import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> de = new ArrayDeque<>();
        int num = 1;

        for (int i = 0; i < n; i++) {
            int val = arr[i];
            if (val == 1) {
                de.offerFirst(num);
                num++;
            } else if (val == 2) {
                int temp = de.pollFirst();
                de.offerFirst(num);
                de.offerFirst(temp);
                num++;
            } else {
                de.offerLast(num);
                num++;
            }
        }
        StringBuilder sb = new StringBuilder();
        int size = de.size();
        for (int i = 0; i < size; i++) {
            sb.append(de.pollFirst()).append(" ");
        }
        System.out.println(sb);
    }
}