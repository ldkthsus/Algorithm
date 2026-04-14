import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(br.readLine());
        }
        List<String> temp = new ArrayList<>();
        for(int i = 0; i < n; i++){
            temp.add(list.get(i));
        }
        Collections.sort(temp);
        if(list.equals(temp)){
            System.out.println("INCREASING");
            return;
        }else{
            temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                temp.add(list.get(i));
            }
            Collections.sort(temp, Collections.reverseOrder());
            if(list.equals(temp)){
                System.out.println("DECREASING");
                return;
            }else{
                System.out.println("NEITHER");
                return;
            }
        }
    }
}