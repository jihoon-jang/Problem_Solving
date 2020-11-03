import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2665 {
    
    static int n, map[][], dp[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < n; j++)
                map[i][j] = input.charAt(j) - '0';
        }
    
        maze();
        System.out.println(dp[n-1][n-1]);
    }
    
    public static void maze() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        dp[0][0] = 0;
        
        while(!q.isEmpty()) {
            Point now = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(check(nx, ny) && (dp[nx][ny] == -1 || dp[nx][ny] > dp[now.x][now.y] + (map[nx][ny] == 0 ? 1 : 0))) {
                    dp[nx][ny] =  dp[now.x][now.y] + (map[nx][ny] == 0 ? 1 : 0);
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }
    
    public static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
    
    static class Point{
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
