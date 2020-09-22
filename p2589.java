import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class p2589 {
    
    static int n, m, answer;
    static char map[][];
    static Stack<Point> st;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        answer = 0;
        map = new char[n][m];
        st = new Stack<>();
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'L')
                    st.push(new Point(i, j, 0));
            }
        }
        while(!st.isEmpty()) {
            Point now = st.pop();
            find(now);
        }
        System.out.println(answer);
    }
    
    public static void find(Point now) {
        boolean visit[][] = new boolean[n][m];
        Queue<Point> q = new LinkedList<>();
        visit[now.x][now.y] = true;
        q.offer(now);
        
        while(!q.isEmpty()) {
            Point p = q.poll();
            answer = Math.max(p.dis, answer);
            
            for(int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                
                if(check(x, y) && !visit[x][y]) {
                    visit[x][y] = true;
                    q.offer(new Point(x, y, p.dis + 1));
                }
            }
        }
    }
    
    public static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m && map[x][y] == 'L';
    }
    
    static class Point{
        int x, y, dis;
        
        Point(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
