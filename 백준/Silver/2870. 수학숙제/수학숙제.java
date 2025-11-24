import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                char word = str.charAt(j);
                if (Character.isDigit(word)) {
                    sb.append(word);
                } else {
                    if (sb.length() > 0) {
                        list.add(change(sb.toString()));
                    }
                    sb.setLength(0);
                }
            }
            if (sb.length() > 0) {
                list.add(change(sb.toString()));
            }
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length())
                    return o1.length() - o2.length();
                else return o1.compareTo(o2);
            }
        });
        StringBuilder strB = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            strB.append(list.get(i)).append("\n");
        }
        System.out.println(strB);
    }

    public static String change(String str) {
        int len = str.length();
        int idx = -1;
        for (int i = 0; i < len; i++) {
            int num = str.charAt(i) - '0';

            if (num != 0) {
                idx = i;
                break;
            }
        }
        if (idx < 0) {
            return "0";
        }
        else return str.substring(idx, len);
    }
}