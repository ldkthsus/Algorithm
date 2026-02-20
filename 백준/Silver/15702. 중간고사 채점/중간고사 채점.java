import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int problem[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            problem[i] = Integer.parseInt(st.nextToken());
        }
        Student arr[] = new Student[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int sum = 0;

            for (int j = 0; j < n; j++) {
                char jeomsu = st.nextToken().charAt(0);
                if (jeomsu == 'O') {
                    sum += problem[j];
                }
            }
            arr[i] = new Student(num, sum);
        }
        Arrays.sort(arr);
        System.out.println(arr[0].num + " " + arr[0].score);

    }

    public static class Student implements Comparable<Student> {
        int num;
        int score;

        public Student(int n, int s) {
            this.num = n;
            this.score = s;
        }

        @Override
        public int compareTo(Student o) {
            if (this.score == o.score) {
                return this.num - o.num;
            } else return o.score - this.score;
        }
    }
}