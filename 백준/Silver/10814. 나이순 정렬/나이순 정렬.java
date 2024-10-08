import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        member [] members = new member[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members[i] = new member(age, name, i);
        }

        Arrays.sort(members);
        for (int i = 0; i < members.length; i++) {
            sb.append(members[i].age + " " + members[i].name + "\n");
        }
        System.out.println(sb);
    }

    public static class member implements Comparable<member> {
        int age;
        String name;
        int num;

        public member(int age, String name, int num) {
            this.age = age;
            this.name = name;
            this.num = num;
        }

        @Override
        public int compareTo(member o) {
            if(this.age == o.age){
                return this.num - o.num;
            }
            return this.age - o.age;
        }
    }
}