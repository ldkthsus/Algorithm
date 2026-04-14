import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int arr[] = new int[300001];
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[num]++;
            max = Math.max(max, num);
        }
        long cnt = 0;
        while (true) {
            if (d == 0) {
                break;
            }
            cnt += arr[max];
            if (max - 1 == 0) {
                break;
            }
            arr[max - 1] += arr[max];
            arr[max] = 0;
            max--;
            d--;
        }
        System.out.println(cnt);
    }
}