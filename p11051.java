import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11051 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());
        
        int dp[][] = new int[n+1][n+1];
        
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= i; j++) {
                if(i == j || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = (dp[i-1][j-1]+dp[i-1][j]) % 10007;
            }
        }
    
        System.out.println(dp[n][k]);
    }
}
