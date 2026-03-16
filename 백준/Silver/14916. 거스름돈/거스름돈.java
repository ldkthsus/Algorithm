import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int five = n / 5;
        int rest = n - (5 * five);
        int two = rest / 2;
        boolean check = true;
        if (five == 0) {
            if (rest % 2 != 0) {
                System.out.println(-1);
                return;
            }
        }
        while (true) {
            if (five < 0) {
                check = false;
                break;
            }
            if (rest % 2 == 0) {
                break;
            }
            five--;
            rest = n - (5 * five);
            two = rest / 2;
        }
        if (!check) {
            System.out.println(-1);
        } else
            System.out.println(five + two);
    }
}