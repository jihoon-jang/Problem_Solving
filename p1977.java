import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p1977 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        boolean number[] = new boolean[10001];
        
        for(int i = 1; i*i <= 10000; i++){
            number[i*i] = true;
        }
        
        int sum = 0;
        int min = 10000;
        for(int i = m; i <= n; i++){
            if(number[i]) {
                sum += i;
                if(min == 10000)
                    min = i;
            }
        }
        
        if(sum != 0)
            System.out.println(sum + "\n" + min);
        else
            System.out.println(-1);
    }
}
