import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1405 {
    
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int n;
    static boolean visit[][];
    static double answer, dir[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        visit = new boolean[n*2+1][n*2+1];
        dir = new double[4];
        answer = 0;
        for(int i = 0; i < 4; i++)
            dir[i] = Integer.parseInt(stz.nextToken()) * 0.01;
        
        visit[n][n] = true;
        dfs(n, n, 1, 0);
        System.out.println(answer);
    }
    
    public static void dfs(int x, int y, double per, int count) {
        if(count == n) {
            answer += per;
            return;
        }
        
        for(int i = 0; i < 4; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(!visit[nx][ny]) {
                visit[nx][ny] = true;
                dfs(nx, ny, per * dir[i], count + 1);
                visit[nx][ny] = false;
            }
        }
    }
}
