import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2096 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int n = Integer.parseInt(br.readLine());
        int map[][] = new int[n][3];
        for(int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++)
                map[i][j] = Integer.parseInt(stz.nextToken());
        }
        
        int dp[][] = new int[n][3];
        dp[0][0] = map[0][0];
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][2];
    
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                switch(j) {
                    case 0 :
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j+1]) + map[i][j];
                        break;
                    case 1 :
                        dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i-1][j+1], dp[i-1][j-1])) + map[i][j];
                        break;
                    case 2 :
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + map[i][j];
                        break;
                }
            }
        }
        int max = Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
        
        dp = new int[n][3];
        dp[0][0] = map[0][0];
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][2];
    
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                switch(j) {
                    case 0 :
                        dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + map[i][j];
                        break;
                    case 1 :
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j+1], dp[i-1][j-1])) + map[i][j];
                        break;
                    case 2 :
                        dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + map[i][j];
                        break;
                }
            }
        }
    
        int min = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    
        System.out.println(max + " " + min);
    }
}
