import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        PriorityQueue<String> pq = new PriorityQueue<>();
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        StringBuilder c = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length() - 2; i++){
            a.append(str.charAt(i));
            a.reverse();
            for(int j = i + 1; j < str.length() - 1; j++){
                b.append(str.charAt(j));
                b.reverse();
                for(int z = j + 1; z < str.length(); z++){
                    c.append(str.charAt(z));
                }
                c.reverse();
                sb.append(a).append(b).append(c);
                pq.offer(sb.toString());
                sb.setLength(0);
                c.setLength(0);
                b.reverse();
            }
            b.setLength(0);
            a.reverse();
        }
        System.out.println(pq.poll());
    }
}