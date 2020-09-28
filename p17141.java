import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17141 {
    
    static int n, m, answer, map[][];
    static ArrayList<Point> al = new ArrayList<>();
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        answer = Integer.MAX_VALUE;
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(stz.nextToken());
                if(map[i][j] == 2)
                    al.add(new Point(i, j));
            }
        }
        
        dfs(0, 0, "", new boolean[al.size()]);
        
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
    
    public static void dfs(int count, int start, String s, boolean visit[]) {
        if(count == m) {
            virus(s.split(" "));
            return;
        }
        
        for(int i = start; i < al.size(); i++) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(count + 1, i, s + i + " ", visit);
                visit[i] = false;
            }
        }
    }
    
    public static void virus(String s[]) {
        Queue<Point> q = new LinkedList<>();
        boolean visit[][] = new boolean[n][n];
        for(String num : s) {
            int index = Integer.parseInt(num);
            q.offer(al.get(index));
            visit[al.get(index).x][al.get(index).y] = true;
        }
        q.offer(new Point(-1, -1));
        int time = -1;
        
        while(!q.isEmpty()) {
            Point now = q.poll();
            
            if(now.x == -1) {
                time++;
                if(!q.isEmpty())
                    q.offer(now);
                continue;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(check(nx, ny) && map[nx][ny] != 1 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
            }
        }
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(!visit[i][j] && map[i][j] == 0)
                    return;
        answer = Math.min(answer, time);
    }
    
    public static boolean check(int x, int y){
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
