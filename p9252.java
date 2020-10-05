import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p9252 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        
        String dp[][] = new String[s1.length()+1][s2.length()+1];
        String max = "";
        
        for(int i = 0; i <= s1.length(); i++)
            Arrays.fill(dp[i], "");
        
        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i-1);
                    if(max.length() < dp[i][j].length())
                        max = dp[i][j];
                }
                else
                    dp[i][j] = dp[i-1][j].length() > dp[i][j-1].length() ? dp[i-1][j] : dp[i][j-1];
            }
        }
    
        System.out.println(max.length() + "\n" + max);
    }
}
