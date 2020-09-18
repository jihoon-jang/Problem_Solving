import java.io.*;
import java.util.*;

public class p19236 {
    public static int map[][];
    public static int N = 4;
    public static int answer = 0;
    /*↑, ↖, ←, ↙, ↓, ↘, →, ↗*/
    public static int dx[] = {0,-1, -1, 0, 1, 1, 1, 0, -1};
    public static int dy[] = {0,0, -1, -1, -1, 0, 1, 1, 1};
    public static Fish shark;
    public static Fish fish[] = new Fish[17];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int n = Integer.parseInt(stz.nextToken());
                int d = Integer.parseInt(stz.nextToken());
                map[i][j] = n;
                fish[n] = new Fish(n, d, i, j);
            }
        }
        shark = new Fish(fish[map[0][0]].number, fish[map[0][0]].direction, 0, 0);
        fish[map[0][0]].number = 0;
        map[0][0] = 0;
        answer = shark.number;
        move();
        start();
        System.out.println(answer);
    }
    
    public static void start() {
        Fish store[] = new Fish[17];
        for(int i = 1; i <= 16; i++)
            store[i] = new Fish(fish[i].number, fish[i].direction, fish[i].x, fish[i].y);
        int copy[][] = new int[N][N];
        for(int i = 0; i < N; i++)
            copy[i] = map[i].clone();
        int sN = shark.number;
        int sD = shark.direction;
        int sX = shark.x;
        int sY = shark.y;
        for(int i = 1; i <= 3; i++) {
            int x = shark.x + dx[shark.direction] * i;
            int y = shark.y + dy[shark.direction] * i;
    
            if(x >= 0 && y >= 0 && x < N && y < N && map[x][y] != 0 && fish[map[x][y]].number != 0) {
                Fish feed = fish[map[x][y]];
                shark.number += feed.number;
                shark.direction = feed.direction;
                feed.number = 0;
                map[x][y] = 0;
                shark.x = x;
                shark.y = y;
                answer = Math.max(shark.number, answer);
                move();
                start();
                for(int a = 1; a <= 16; a++)
                    fish[a] = new Fish(store[a].number, store[a].direction, store[a].x, store[a].y);
                for(int b = 0; b < N; b++)
                    map[b] = copy[b].clone();
                shark.number = sN;
                shark.direction = sD;
                shark.x = sX;
                shark.y = sY;
            }
        }
    }
    
    public static void print(int map[][]) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                System.out.printf("%-2d ", map[i][j]);
            System.out.println();
        }
    }
    
    public static void move() {
        for(int i = 1; i <= 16; i++) {
            if(fish[i].number != 0) {
                Fish now = fish[i];
                now.direction--;
                for(int j = 0; j < 9; j++) {
                    now.direction++;
                    now.direction %= 9;
                    if(now.direction == 0)
                        now.direction = 1;
                    int x = now.x + dx[now.direction];
                    int y = now.y + dy[now.direction];
                    
                    if(check(x, y)) {
                        if(map[x][y] == 0) {
                            map[now.x][now.y] = 0;
                            map[x][y] = i;
                        }
                        else {
                            Fish temp = fish[map[x][y]];
                            map[now.x][now.y] = map[x][y];
                            map[x][y] = i;
                            temp.x = now.x;
                            temp.y = now.y;
                        }
                        now.x = x;
                        now.y = y;
                        break;
                    }
                }
            }
        }
    }
    
    public static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N && !(shark.x == x && shark.y == y);
    }
    
    static class Fish {
        int x, y;
        int number, direction;
        
        Fish(int number, int direction, int x, int y) {
            this.number = number;
            this.direction = direction;
            this.x = x;
            this.y = y;
        }
    }
}