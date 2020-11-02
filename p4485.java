import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p4485 {
    
    static int map[][], dp[][], n;
    static boolean visit[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int game = 1;
        while(n != 0) {
            map = new int[n][n];
            dp = new int[n][n];
            visit = new boolean[n][n];
            for(int i = 0; i < n; i++) {
                StringTokenizer stz = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++)
                    map[i][j] = Integer.parseInt(stz.nextToken());
                Arrays.fill(dp[i], -1);
            }
            find();
            System.out.printf("Problem %d: %d\n", game++, dp[n-1][n-1]);
            n = Integer.parseInt(br.readLine());
        }
    }
    
    public static void find() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        dp[0][0] = map[0][0];
        
        while(!q.isEmpty()) {
            Point now = q.poll();
            
            if(!visit[now.x][now.y]) {
                visit[now.x][now.y] = true;
                
                for(int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    
                    if(check(nx, ny) && (dp[nx][ny] == -1 || dp[nx][ny] > dp[now.x][now.y] + map[nx][ny])) {
                        dp[nx][ny] = dp[now.x][now.y] + map[nx][ny];
                        visit[nx][ny] = false;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }
    
    public static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
    
    static class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
