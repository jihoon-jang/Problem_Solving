import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p2576 {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = 987654;
        int sum = 0;
        for(int i = 0; i < 7; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n % 2 == 1) {
                sum += n;
                min = Math.min(min, n);
            }
        }
        
        if(sum != 0)
            System.out.println(sum + "\n" + min);
        else
            System.out.println(-1);
    }
}
