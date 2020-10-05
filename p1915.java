import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1915 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int map[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++)
                map[i][j] = line.charAt(j) - '0';
        }
        int max = 0;
        
        int dp[][] = new int[n][m];
        for(int i = 0; i < n; i++)
            if(map[i][0] == 1) {
                dp[i][0] = 1;
                max = 1;
            }
        for(int i = 0; i < m; i++)
            if(map[0][i] == 1){
                dp[0][i] = 1;
                max = 1;
            }
        
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(map[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        System.out.println(max*max);
    }
}
