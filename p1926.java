import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1926 {
    
    static int n, m, max, count, map[][], counting;
    static boolean visit[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(stz.nextToken());
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visit[i][j] && map[i][j] == 1) {
                    count++;
                    counting = 1;
                    visit[i][j] = true;
                    dfs(i, j);
                    max = Math.max(counting, max);
                }
            }
        }
    
        System.out.println(count + "\n" + max);
    }
    
    public static void dfs(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(check(nx, ny) && !visit[nx][ny] && map[nx][ny] == 1) {
                visit[nx][ny] = true;
                counting++;
                dfs(nx, ny);
            }
        }
    }
    
    public static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
