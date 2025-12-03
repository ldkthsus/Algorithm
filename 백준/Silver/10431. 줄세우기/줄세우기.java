import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int tc = Integer.parseInt(st.nextToken());

            int arr[] = new int[20];
            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;

            for (int i = 1; i < 20; i++) {
                int now = arr[i];
                for (int j = 0; j < i; j++) {
                    if (arr[j] > now) {
                        List<Integer> list = new ArrayList<>();
                        for (int a = j; a <= i - 1; a++) {
                            list.add(arr[a]);
                        }
                        arr[j] = now;
                        int idx = j + 1;
                        for (int a = 0; a < list.size(); a++) {
                            arr[idx] = list.get(a);
                            idx++;
                        }
                        cnt += list.size();
                        break;
                    }
                }
            }
            sb.append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}