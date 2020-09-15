import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17143 {
    
    public static int map[][];
    public static Shark array[];
    public static int dx[] = {0,-1,1,0,0};
    public static int dy[] = {0,0,0,1,-1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(stz.nextToken());
        int c = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        map = new int[r+1][c+1];
        array = new Shark[m+1];
        
        for(int i = 1; i <= m; i++) {
            stz = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stz.nextToken());
            int y = Integer.parseInt(stz.nextToken());
            int s = Integer.parseInt(stz.nextToken());
            int d = Integer.parseInt(stz.nextToken());
            int z = Integer.parseInt(stz.nextToken());
            if(d == 3 || d == 4) {
                if(s > (c - 1) * 2)
                    s %= (c - 1) * 2;
            }
            else {
                if(s > (r - 1) * 2)
                    s %= (r - 1) * 2;
            }
            map[x][y] = i;
            array[i] = new Shark(x, y, s, d, z);
        }
        
        int answer = 0;
        int fisher = 0;
        for(int i = 0; i < c; i++) {
            fisher++;
            answer += fishing(fisher, r);
            move(r, c, m);
        }
        
        System.out.println(answer);
    }
    
    public static void print(int r, int c) {
        for(int i = 1; i <= r; i++) {
            for(int j = 1; j <= c; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }
    
    public static void move(int r, int c, int m) {
        int temp[][] = new int[r+1][c+1];
        for(int i = 1; i <= m; i++) {
            Shark sk = array[i];
            if(sk.size == 0)
                continue;
            for(int j = 1; j <= sk.speed; j++) {
                int x = sk.x + dx[sk.dir];
                int y = sk.y + dy[sk.dir];
                
                if(!check(x, y, r, c)) {
                    if(sk.dir == 1)
                        sk.dir = 2;
                    else if(sk.dir == 2)
                        sk.dir = 1;
                    else if(sk.dir == 4)
                        sk.dir = 3;
                    else if(sk.dir == 3)
                        sk.dir = 4;
                }
                sk.x += dx[sk.dir];
                sk.y += dy[sk.dir];
            }
            
            if(temp[sk.x][sk.y] != 0) {
                int num = temp[sk.x][sk.y];
                if(array[num].size > sk.size)
                    sk.size = 0;
                else{
                    temp[sk.x][sk.y] = i;
                    array[num].size = 0;
                }
            }
            else
                temp[sk.x][sk.y] = i;
        }
        
        for(int i = 1; i <= r; i++)
            map[i] = temp[i].clone();
    }
    
    public static int fishing(int fisher, int r) {
        int score = 0;
        int number = 0;
        for(int i = 1; i <= r; i++) {
            if(map[i][fisher] != 0){
                number = map[i][fisher];
                score = array[number].size;
                map[i][fisher] = 0;
                array[number].size = 0;
                break;
            }
        }
        return score;
    }
    
    public static boolean check(int x, int y, int r, int c) {
        return x >= 1 && y >= 1 && x <= r && y <= c;
    }
    
    static class Shark {
        int x, y, speed, dir, size;
        
        Shark(int x, int y, int speed, int dir, int size){
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }
    }
}
