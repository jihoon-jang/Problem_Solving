import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p19238 {
    
    static int n, m, fuel,map[][];
    static Pass pass[];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        fuel = Integer.parseInt(stz.nextToken());
        map = new int[n][n];
        pass = new Pass[m+1];
        for(int i = 0; i < n; i++){
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stz.nextToken());
                if(map[i][j] == 1)
                    map[i][j] = -1;
            }
        }
        stz = new StringTokenizer(br.readLine());
        Taxi taxi = new Taxi(Integer.parseInt(stz.nextToken())-1, Integer.parseInt(stz.nextToken())-1, fuel);
        for(int i = 1; i <= m; i++) {
            stz = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stz.nextToken())-1;
            int y = Integer.parseInt(stz.nextToken())-1;
            map[x][y] = i;
            x = Integer.parseInt(stz.nextToken())-1;
            y = Integer.parseInt(stz.nextToken())-1;
            pass[i] = new Pass(x, y);
        }
        
        for(int i = 0; i < m; i++){
            if(!findPass(taxi)) {
                System.out.println(-1);
                return;
            }
            int nowFuel = taxi.fuel;
            if(!findHome(taxi)){
                System.out.println(-1);
                return;
            }
            taxi.fuel += (nowFuel - taxi.fuel) * 2;
        }
        System.out.println(taxi.fuel);
    }
    
    public static boolean findHome(Taxi taxi) {
        boolean visit[][] = new boolean[n][n];
        Queue<Taxi> q = new LinkedList<>();
        q.offer(taxi);
        visit[taxi.x][taxi.y] = true;
        
        while(!q.isEmpty()) {
            Taxi now = q.poll();
            if(now.x == pass[taxi.pass].x && now.y == pass[taxi.pass].y){
                taxi.fuel = now.fuel;
                taxi.x = now.x;
                taxi.y = now.y;
                return true;
            }
            if(now.fuel == 0)
                continue;
            
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(check(nx, ny) && !visit[nx][ny] && map[nx][ny] != -1) {
                    visit[nx][ny] = true;
                    q.offer(new Taxi(nx, ny, now.fuel - 1));
                }
            }
        }
        return false;
    }
    
    public static boolean findPass(Taxi taxi) {
        boolean visit[][] = new boolean[n][n];
        Queue<Taxi> q = new LinkedList<>();
        q.add(taxi);
        visit[taxi.x][taxi.y] = true;
        LinkedList<Pass> list = new LinkedList<>();
        int find = 0;
        while(!q.isEmpty()) {
            Taxi now = q.poll();
            if(map[now.x][now.y] != 0){
                if(find != 0){
                    if(find != now.fuel)
                        continue;
                }
                list.add(new Pass(now.x, now.y));
                find = now.fuel;
                taxi.fuel = now.fuel;
                continue;
            }
            if(now.fuel == 0)
                continue;
            if(find < now.fuel) {
                for(int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if(check(nx, ny) && !visit[nx][ny] && map[nx][ny] != -1) {
                        visit[nx][ny] = true;
                        q.offer(new Taxi(nx, ny, now.fuel - 1));
                    }
                }
            }
        }
        if(list.size() == 0)
            return false;
        Collections.sort(list, new Comparator<Pass>() {
            public int compare(Pass o1, Pass o2) {
                if(o1.x == o2.x)
                    return o1.y - o2.y;
                return o1.x - o2.x;
            }
        });
        Pass p = list.get(0);
        taxi.x = p.x;
        taxi.y = p.y;
        taxi.pass = map[p.x][p.y];
        map[p.x][p.y] = 0;
        
        return true;
    }
    
    public static boolean check(int x, int y){
        return x >= 0 && y >= 0 && x < n && y < n;
    }
    
    static class Taxi{
        int x, y, fuel, pass;
        
        Taxi(int x, int y, int f){
            this.x = x;
            this.y = y;
            this.fuel = f;
            pass = 0;
        }
    }
    
    static class Pass{
        int x, y;
        
        Pass(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}