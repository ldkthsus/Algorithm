import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            int a = Integer.parseInt(br.readLine());
            int aArr[] = new int[a];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < a; j++) {
                aArr[j] = Integer.parseInt(st.nextToken());
            }

            int b = Integer.parseInt(br.readLine());
            int bArr[] = new int[b];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < b; j++) {
                bArr[j] = Integer.parseInt(st.nextToken());
            }

            int c = Integer.parseInt(br.readLine());
            int cArr[] = new int[c];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                cArr[j] = Integer.parseInt(st.nextToken());
            }

            Set<Integer> set = new HashSet<>();
            for (int numA : aArr) {
                for (int numB : bArr) {
                    for (int numC : cArr) {
                        boolean check = true;
                        int sum = numA + numB + numC;
                        int test = sum;

                        while (test > 0) {
                            int word = test % 10;
                            if (word != 5 && word != 8) {
                                check = false;
                                break;
                            }
                            test = test / 10;
                        }
                        if (check)
                            set.add(sum);
                    }
                }
            }
            sb.append(set.size()).append("\n");
        }
        System.out.println(sb);
    }
}