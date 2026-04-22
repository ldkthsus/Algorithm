import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static String[] result;
    public static boolean[] isUsed;
    public static List<String> list;
    public static Queue<Integer> queue;
    public static List<Integer> resultList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        queue = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        int[] op = new int[4];
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        if (op[0] > 0) {
            for (int j = 0; j < op[0]; j++) {
                list.add("+");
            }
        }
        if (op[1] > 0) {
            for (int j = 0; j < op[1]; j++) {
                list.add("-");
            }
        }
        if (op[2] > 0) {
            for (int j = 0; j < op[2]; j++) {
                list.add("X");
            }
        }
        if (op[3] > 0) {
            for (int j = 0; j < op[3]; j++) {
                list.add("/");
            }
        }

        int size = list.size();
        result = new String[size];
        isUsed = new boolean[size];
        resultList = new ArrayList<>();
        Perm(0);
        Collections.sort(resultList);
        int len = resultList.size();
        System.out.println(resultList.get(len - 1));
        System.out.println(resultList.get(0));
    }

    public static void Perm(int idx) {
        if (idx == list.size()) {
            Cal(result);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!isUsed[i]) {
                result[idx] = list.get(i);
                isUsed[i] = true;
                Perm(idx + 1);
                isUsed[i] = false;
            }
        }
    }

    public static void Cal(String[] re) {
        int first = queue.poll();
        int second = queue.poll();
        queue.offer(first);
        queue.offer(second);
        String op = re[0];
        int result = 0;
        result = Change(first, second, op);

        for (int i = 1; i < re.length; i++) {
            int next = queue.poll();
            String operation = re[i];
            if (result < 0 && operation == "/") {
                int temp = result * -1;
                int val = Change(temp, next, operation);
                result = val * -1;
            } else {
                int val = Change(result, next, operation);
                result = val;
            }
            queue.offer(next);
        }
        resultList.add(result);
    }

    public static int Change(int first, int second, String operation) {
        if (operation == "+")
            return first + second;
        else if (operation == "-")
            return first - second;
        else if (operation == "X")
            return first * second;
        else
            return first / second;
    }
}