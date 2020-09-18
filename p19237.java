import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p19237 {
    
    static int n, m, k, map[][];
    static Smell smell[][];
    static int dx[] = {0,-1,1,0,0};
    static int dy[] = {0,0,0,-1,1};
    static Shark shark[]; //상어의 정보
    static int count; //상어의 수
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        shark = new Shark[m+1];
        for(int i = 1; i <= m; i++)
            shark[i] = new Shark();
        map = new int[n][n];
        smell = new Smell[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                smell[i][j] = new Smell();
        count = m;
        
        for(int i = 0; i < n; i++){
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stz.nextToken());
                if(map[i][j] != 0){
                    shark[map[i][j]].x = i;
                    shark[map[i][j]].y = j;
                }
            }
        }
        stz = new StringTokenizer(br.readLine());
        for(int i = 1; i <= m; i++)
            shark[i].setShark(i, Integer.parseInt(stz.nextToken()));
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= 4; j++) {
                stz = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(stz.nextToken());
                int n2 = Integer.parseInt(stz.nextToken());
                int n3 = Integer.parseInt(stz.nextToken());
                int n4 = Integer.parseInt(stz.nextToken());
                shark[i].priority[j] = new int[] {n1, n2, n3, n4};
            }
        }
        int time = 1;
        ppoong();
        for(; time <= 1001; time++) {
            if(time == 1001 && count != 1){
                System.out.println(-1);
                return;
            }
            else if(time == 1001 && count == 1) {
                System.out.println(1000);
                return;
            }
            if(count == 1){
                System.out.println(time-1);
                return;
            }
            move();
            ppoong();
            clean();
        }
    }
    
    public static void ppoong() {
        for(int i = 1; i <= m; i++) {
            Shark now = shark[i];
            if(now.number != 0)
                smell[now.x][now.y].setSmell(i, k);
        }
    }
    
    public static void move() {
        for(int i = 1; i <= m; i++) {
            Shark now = shark[i];
            if(now.number != 0) {
                check(now);
            }
        }
    }
    
    public static void clean() {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(smell[i][j].time > 0 && map[i][j] == 0)
                    smell[i][j].time--;
                if(smell[i][j].time == 0)
                    smell[i][j].number = 0;
            }
        }
    }
    
    public static void check(Shark now) {
        for(int j = 0; j < 4; j++) {
            int dir = now.priority[now.direction][j];
            int nx = now.x + dx[dir];
            int ny = now.y + dy[dir];
            
            if(nx >= 0 && ny >= 0 && nx < n && ny < n && smell[nx][ny].number == 0){
                if(map[nx][ny] != 0) {
                    if(eat(now, nx, ny))
                        return;
                }
                now.direction = dir;
                map[now.x][now.y] = 0;
                now.x = nx;
                now.y = ny;
                map[nx][ny] = now.number;
                return;
            }
        }
        
        for(int j = 0; j < 4; j++) {
            int dir = now.priority[now.direction][j];
            int nx = now.x + dx[dir];
            int ny = now.y + dy[dir];
            
            if(nx >= 0 && ny >= 0 && nx < n && ny < n && smell[nx][ny].number == now.number){
                now.direction = dir;
                map[now.x][now.y] = 0;
                now.x = nx;
                now.y = ny;
                map[nx][ny] = now.number;
                return;
            }
        }
    }
    
    public static void print() {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                System.out.print(smell[i][j].time + " ");
            System.out.println();
        }
        System.out.println();
    }
    
    public static boolean eat(Shark now, int x, int y) {
        if(shark[map[x][y]].number < now.number){
            now.number = 0;
            map[now.x][now.y] = 0;
            count--;
            return true;
        }
        
        return false;
    }
    
    static class Shark {
        int x, y, number, direction, priority[][];
        
        Shark() {}
        
        void setShark(int n, int d){
            this.number = n;
            this.direction = d;
            priority = new int[5][4];
        }
    }
    
    static class Smell {
        int number, time;
        
        Smell(){
            this.number = 0;
            this.time = 0;
        }
        
        void setSmell(int n, int t) {
            this.number = n;
            this.time = t;
        }
        
        void set(){
            number = 0;
            time = 0;
        }
    }
}
