import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class p2146 {
    
    static int n, map[][], island[][];
    static boolean visit[][];
    static Stack<Point> start;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        island = new int[n][n];
        visit = new boolean[n][n];
        start = new Stack<>();
        for(int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stz.nextToken());
                if(map[i][j] == 1)
                    start.push(new Point(i, j, 0));
            }
        }
        int number = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1 && !visit[i][j]) {
                    island[i][j] = number;
                    visit[i][j] = true;
                    tie(i, j, number);
                    number++;
                }
            }
        }
        
        while(!start.isEmpty()) {
            Point now = start.pop();
            
            bridge(now.x, now.y);
        }
        System.out.println(answer-1);
    }
    
    public static void tie(int x, int y, int number) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(check(nx, ny) && !visit[nx][ny] && map[nx][ny] == 1) {
                island[nx][ny] = number;
                visit[nx][ny] = true;
                tie(nx, ny, number);
            }
        }
    }
    
    public static void bridge(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y, 0));
        int number = island[x][y];
        visit = new boolean[n][n];
        visit[x][y] = true;
        
        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.count >= answer)
                return;
            if(island[now.x][now.y] != 0 && island[now.x][now.y] != number) {
                answer = Math.min(answer, now.count);
                return;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(check(nx, ny) && !visit[nx][ny] && island[nx][ny] != number) {
                    visit[nx][ny] = true;
                    q.offer(new Point(nx, ny, now.count + 1));
                }
            }
        }
    }
    
    public static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
    
    static class Point{
        int x, y, count;
        
        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
