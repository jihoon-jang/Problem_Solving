import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1520 {
    
    static int n, m, map[][], dp[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stz.nextToken());
        n = Integer.parseInt(stz.nextToken());
        map = new int[m][n];
        dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(stz.nextToken());
        }
        
        for(int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);
        
        find(0, 0);
        System.out.println(dp[0][0]);
    }
    
    public static int find(int x, int y) {
        if(x == m-1 && y == n-1)
            return 1;
        
        if(dp[x][y] == -1) {
            dp[x][y] = 0;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
        
                if(check(nx, ny) && map[x][y] > map[nx][ny])
                    dp[x][y] += find(nx, ny);
            }
        }
        
        return dp[x][y];
    }
    
    public static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
