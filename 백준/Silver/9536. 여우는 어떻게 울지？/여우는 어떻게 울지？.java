import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < TC; t++) {
            String str[] = br.readLine().split(" ");
            while (true) {
                String animal = br.readLine();
                if (animal.contains("what")) {
                    for (int i = 0; i < str.length; i++) {
                        if (!str[i].equals("-")) {
                            sb.append(str[i]).append(" ");
                        }
                    }
                    break;
                }
                String word[] = animal.split(" ");
                for (int j = 0; j < str.length; j++) {
                    if (word[2].equals(str[j])) {
                        str[j] = "-";
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}