import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1600 {
    
    static int map[][], distance[][][], w, h, k;
    static boolean visit[][][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int jx[] = {-2,-1,1,2,2,1,-1,-2};
    static int jy[] = {1,2,2,1,-1,-2,-2,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        k = Integer.parseInt(br.readLine());
        stz = new StringTokenizer(br.readLine());
        w = Integer.parseInt(stz.nextToken());
        h = Integer.parseInt(stz.nextToken());
        if(h == 1 && w == 1){
            System.out.println(0);
            return;
        }
        map = new int[h][w];
        distance = new int[h][w][k+1];
        visit = new boolean[h][w][k+1];
        for(int i = 0; i < h; i++) {
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++)
                map[i][j] = Integer.parseInt(stz.nextToken());
        }
        bfs();
        
        int min = 987654321;
        for(int i = 0; i <= k; i++)
            if(distance[h-1][w-1][i] != 0)
                min = Math.min(min, distance[h-1][w-1][i]);
        
        System.out.println(min == 987654321 ? -1 : min);
    }
    
    public static void bfs() {
        Queue<Monkey> q = new LinkedList<>();
        q.offer(new Monkey(0, 0, 0));
        
        while(!q.isEmpty()) {
            Monkey now = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(check(nx, ny) && map[nx][ny] == 0 && (!visit[nx][ny][now.jump] || distance[nx][ny][now.jump] > distance[now.x][now.y][now.jump] + 1)) {
                    distance[nx][ny][now.jump] = distance[now.x][now.y][now.jump] + 1;
                    visit[nx][ny][now.jump] = true;
                    q.offer(new Monkey(nx, ny, now.jump));
                }
            }
            
            if(now.jump < k){
                for(int i = 0; i < 8; i++) {
                    int nx = now.x + jx[i];
                    int ny = now.y + jy[i];
                    
                    if(check(nx, ny) && map[nx][ny] == 0 && (!visit[nx][ny][now.jump+1] || distance[nx][ny][now.jump+1] > distance[now.x][now.y][now.jump] + 1)) {
                        distance[nx][ny][now.jump+1] = distance[now.x][now.y][now.jump] + 1;
                        visit[nx][ny][now.jump+1] = true;
                        q.offer(new Monkey(nx, ny, now.jump+1));
                    }
                }
            }
        }
    }
    
    public static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < h && y < w;
    }
    
    static class Monkey {
        int x, y, jump;
        
        Monkey(int x, int y, int jump) {
            this.x = x;
            this.y = y;
            this.jump = jump;
        }
    }
}