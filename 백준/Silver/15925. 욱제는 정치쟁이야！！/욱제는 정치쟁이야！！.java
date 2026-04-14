import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n, r;
    public static int arr[][];
    public static int di[] = {0, -1, 1, 0, 0}; //원래 자리, 상, 하, 좌, 우
    public static int dj[] = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                for (int d = 0; d < 5; d++) {
                    int ni = i + di[d];
                    int nj = j + dj[d];

                    if (ni < 0 || ni >= n || nj < 0 || nj >= n)
                        continue;

                    //행 확인
                    int sj = 0;
                    int cnt = 0;
                    for (int s = 0; s < n; s++) {
                        if (arr[ni][sj] == r) {
                            cnt++;
                        }
                        sj++;
                    }
                    if (cnt > n / 2) {
                        sj = 0;
                        for (int s = 0; s < n; s++) {
                            arr[ni][sj] = r;
                            sj++;
                        }
                    }
                    
                    //열 확인
                    int si = 0;
                    cnt = 0;
                    for (int s = 0; s < n; s++) {
                        if (arr[si][nj] == r) {
                            cnt++;
                        }
                        si++;
                    }
                    if (cnt > n / 2) {
                        si = 0;
                        for (int s = 0; s < n; s++) {
                            arr[si][nj] = r;
                            si++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != r) {
                    System.out.println(0);
                    return;
                }
            }
        }
        System.out.println(1);
    }
}