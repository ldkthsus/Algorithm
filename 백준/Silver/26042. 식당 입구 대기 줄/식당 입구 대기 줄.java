import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        int size = -1;
        int max = Integer.MIN_VALUE;
        int num = -1;
        int last = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int val = Integer.parseInt(st.nextToken());
                queue.offer(val);
                last = val;
            } else {
                size = queue.size();
                if (max < size) {
                    max = size;
                    num = last;
                } else if (max == size) {
                    num = Math.min(num, last);
                }
                queue.poll();
            }
        }
        size = queue.size();
        if (max < size) {
            max = size;
            num = last;
        } else if (max == size) {
            num = Math.min(num, last);
        }
        System.out.println(max + " " + num);
    }
}