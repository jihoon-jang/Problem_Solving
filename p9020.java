import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p9020 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        boolean prime[] = new boolean[10001];
        Arrays.fill(prime, true);
        prime[1] = false;
        
        for(int i = 2; i < 10000; i++) {
            for(int j = 2; j * i < 10001; j++)
                prime[i*j] = false;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc < t; tc++) {
            int num = Integer.parseInt(br.readLine());
            for(int i = num/2; i < num; i++) {
                if(prime[i] && prime[num-i]) {
                    sb.append((num - i) + " " + i).append('\n');
                    break;
                }
            }
        }
    
        System.out.println(sb.toString());
    }
}
