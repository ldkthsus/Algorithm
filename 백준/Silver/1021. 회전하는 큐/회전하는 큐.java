import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Deque<Integer> deq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int count = 0;

        List<Integer> list = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < n; i++) {
            deq.offer(i + 1);
        }
        int numIdx = 0;
        while(m-- > 0) {
            int num = list.get(numIdx);
            int idx = findIndex(deq, num);
            int mid = deq.size() / 2;

            if(idx <= mid){
                while(num != deq.peek()){
                    deq.offerLast(deq.pollFirst());
                    count++;
                }
            }else if(idx > mid){
                while(num != deq.peek()){
                    deq.offerFirst(deq.pollLast());
                    count++;
                }
            }
            deq.pollFirst();
            numIdx++;
        }
        System.out.println(count);
    }
    public static int findIndex(Deque<Integer> deq, int number){
        Iterator<Integer> iterator = deq.iterator();
        int index = 0;
        while(iterator.hasNext()){
            if(iterator.next().equals(number)){
                return index;
            }
            index++;
        }
        return -1;
    }
}