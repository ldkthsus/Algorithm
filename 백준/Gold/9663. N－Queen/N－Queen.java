import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n, count = 0, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        //배열의 index가 열, 배열의 값이 행
        //index를 증가시키면 열은 항상 달라지니 가능한 행만 찾음
        arr = new int[n];

        nQueen(0);
        System.out.println(count);


    }

    public static void nQueen(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            if (isPossible(depth)) {
                nQueen(depth + 1);
            }

        }
    }

    public static boolean isPossible(int depth) {
        for (int i = 0; i < depth; i++) {
            //같은 행에 있다는 의미
            //못감
            if (arr[depth] == arr[i]) {
                return false;
            }
            //대각선 확인
            //대각선은 같은 비율로 떨어진 거니까 열의 차와 행의 차가 같은 상황
            else if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}