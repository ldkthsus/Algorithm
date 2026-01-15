import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, String> input = new HashMap<>();
        int num;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();

            if (state.equals("enter")) {
                input.put(name, state);
            } else if (state.equals("leave")) {
                input.remove(name);
            }
        }
        Set<String> set = input.keySet();
        String arr[] = new String[set.size()];
        int j = 0;
        for (String s : set) {
            arr[j] = s;
            j++;
        }
        Arrays.sort(arr, Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}