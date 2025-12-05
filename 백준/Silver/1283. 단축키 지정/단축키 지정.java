import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str[] = br.readLine().split(" ");
            boolean check = false;
            for (int j = 0; j < str.length; j++) { //단어의 첫 글자만 확인
                char now = str[j].charAt(0);
                if (!map.containsKey(Character.toUpperCase(now))) {
                    check = true;
                    map.put(Character.toUpperCase(now), 1);

                    for (int a = 0; a < str.length; a++) {
                        for (int b = 0; b < str[a].length(); b++) {
                            if (a == j && b == 0) {
                                sb.append("[").append(now).append("]");
                                continue;
                            }
                            sb.append(str[a].charAt(b));
                        }
                        sb.append(" ");
                    }
                    break;
                }
            }

            if (!check) {
                naga:
                for (int j = 0; j < str.length; j++) {
                    for (int a = 1; a < str[j].length(); a++) {
                        char now = str[j].charAt(a);
                        if (!map.containsKey(Character.toUpperCase(now))) {
                            check = true;
                            map.put(Character.toUpperCase(now), 1);

                            for (int x = 0; x < str.length; x++) {
                                for (int y = 0; y < str[x].length(); y++) {
                                    if (x == j && a == y) {
                                        sb.append("[").append(now).append("]");
                                        continue;
                                    }
                                    sb.append(str[x].charAt(y));
                                }
                                sb.append(" ");
                            }
                            break naga;
                        }
                    }
                }
            }
            if (!check) {
                for (int a = 0; a < str.length; a++) {
                    for (int b = 0; b < str[a].length(); b++) {
                        sb.append(str[a].charAt(b));
                    }
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}