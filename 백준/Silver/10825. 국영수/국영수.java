import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Subject arr[] = new Subject[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            arr[i] = new Subject(name, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(arr[i].name).append("\n");
        }
        System.out.println(sb);
    }

    public static class Subject implements Comparable<Subject> {
        String name;
        int kor;
        int eng;
        int math;

        public Subject(String n, int k, int e, int m) {
            this.name = n;
            this.kor = k;
            this.eng = e;
            this.math = m;
        }

        @Override
        public int compareTo(Subject o) {
            if (this.kor == o.kor) {
                if (this.eng == o.eng) {
                    if (this.math == o.math) {
                        return this.name.compareTo(o.name);
                    } else return o.math - this.math;
                } else return this.eng - o.eng;
            } else return o.kor - this.kor;
        }
    }
}