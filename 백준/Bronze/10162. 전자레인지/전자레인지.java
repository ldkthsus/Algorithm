import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int change = 0;

        int a = 0;
        int b = 0;
        int c = 0;

        a = target / 300;
        change = target % 300;

        b = change / 60;
        change = change % 60;

        c = change / 10;
        change = change % 10;

        if (change == 0) {
            System.out.println(a + " " + b + " " + c);
        } else System.out.println(-1);
    }
}