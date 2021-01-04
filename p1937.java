import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1937 {
    
    static int n, answer, map[][], dp[][];
    static boolean visit[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        visit = new boolean[n][n];
        
        for(int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(stz.nextToken());
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visit[i][j])
                    dfs(i, j, map[i][j]);
            }
        }
        
        System.out.println(answer);
    }
    
    public static void dfs(int x, int y, int bamboo) {
        int max = 0;
        visit[x][y] = true;
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(check(nx, ny)) {
                if(!visit[nx][ny] && map[nx][ny] > bamboo) 
                    dfs(nx, ny, map[nx][ny]);
                
                if(bamboo < map[nx][ny])
                    max = Math.max(max, dp[nx][ny]);
            }
        }
        
        dp[x][y] = max + 1;
        answer = Math.max(answer, dp[x][y]);
    }
    
    public static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
    
    public static void print() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
    }
}