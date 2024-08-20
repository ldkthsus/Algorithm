import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        int cnt = n;
        int head = 0;
        int tail = 0;

        while (true) {
            if (cnt == 0) {
                break;
            }
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if (order.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                arr[tail++] = num;
            } else if (order.equals("pop")) {
                if (head == tail) {
                    sb.append(-1);
                    sb.append("\n");
                } else {
                    sb.append(arr[head++]);
                    sb.append("\n");
                }
            } else if (order.equals("size")) {
                sb.append(tail - head);
                sb.append("\n");
            } else if (order.equals("empty")) {
                if (head == tail) {
                    sb.append(1);
                    sb.append("\n");
                } else {
                    sb.append(0);
                    sb.append("\n");
                }
            } else if (order.equals("front")) {
                if (head == tail) {
                    sb.append(-1);
                    sb.append("\n");
                } else {
                    sb.append(arr[head]);
                    sb.append("\n");
                }
            } else if (order.equals("back")) {
                if (head == tail) {
                    sb.append(-1);
                    sb.append("\n");
                } else {
                    sb.append(arr[tail - 1]);
                    sb.append("\n");
                }
            }
            cnt--;
        }
        System.out.println(sb);
    }
}