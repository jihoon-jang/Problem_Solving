import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p2010 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i = 0; i < n; i++)
            sum += Integer.parseInt(br.readLine());
        System.out.println(sum - n + 1);
    }
}
