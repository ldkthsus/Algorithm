import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char line[] = br.readLine().toCharArray();
        int num = 1;
        int idx = 0;
        while (true) {
            if (idx == line.length) {
                break;
            }
            char target[] = String.valueOf(num).toCharArray();
            for(int i = 0; i < target.length; i++){
                if(target[i] == line[idx]){
                    idx++;
                    if(idx == line.length)
                        break;
                }
            }
            num++;
        }
        System.out.println(num - 1);
    }
}