import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p2914 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int i = Integer.parseInt(input[1]);
        System.out.println(a*(i-1)+1);
    }
}
