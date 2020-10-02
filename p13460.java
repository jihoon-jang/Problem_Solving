import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p13460 {
    
    static int n, m, answer;
    static char map[][];
    static Bead bead[] = new Bead[2]; // 빨, 파
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        answer = 11;
        map = new char[n][m];
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'R')
                    bead[0] = new Bead(i, j);
                else if(map[i][j] == 'B')
                    bead[1] = new Bead(i, j);
            }
        }
        
        game(1);
        System.out.println(answer == 11 ? -1 : answer);
    }
    
    public static void game(int count) {
        if(count >= answer)
            return;
        Bead copyBead[] = new Bead[2];
        char copyMap[][] = new char[n][m];
        for(int i = 0; i < 2; i++)
            copyBead[i] = new Bead(bead[i].x, bead[i].y);
        for(int i = 0; i < n; i++)
            copyMap[i] = map[i].clone();
        
        int second = 3;
        for(int i = 0; i < 4; i++) {
            boolean change = false;
            if(i == 0) {
                if(bead[0].x < bead[1].x)
                    second = 1;
                else
                    second = 0;
            }
            else
                if(i == 1) {
                    if(bead[0].x < bead[1].x)
                        second = 0;
                    else
                        second = 1;
                }
                else
                    if(i == 2) {
                        if(bead[0].y > bead[1].y)
                            second = 0;
                        else
                            second = 1;
                    }
                    else
                        if(i == 3) {
                            if(bead[0].y < bead[1].y)
                                second = 0;
                            else
                                second = 1;
                        }
            for(int j = 0; j < 2; j++) {
                int nx = bead[j].x + dx[i];
                int ny = bead[j].y + dy[i];
    
                if(check(nx, ny) && map[nx][ny] != '#') {
                    change = true;
                    map[bead[j].x][bead[j].y] = '.';
                    if(map[nx][ny] == 'O') {
                        bead[j].x = -1;
                        bead[j].y = -1;
                        continue;
                    }
                    
                    bead[j].x = nx;
                    bead[j].y = ny;
                    move(nx, ny, i, j);
                }
            }
            if(change) {
                if(bead[1].x == -1) {
                    for(int a = 0; a < 2; a++)
                        bead[a] = new Bead(copyBead[a].x, copyBead[a].y);
                    for(int a = 0; a < n; a++)
                        map[a] = copyMap[a].clone();
                    continue;
                }
                if(bead[0].x == -1) {
                    answer = Math.min(answer, count);
                    for(int a = 0; a < 2; a++)
                        bead[a] = new Bead(copyBead[a].x, copyBead[a].y);
                    for(int a = 0; a < n; a++)
                        map[a] = copyMap[a].clone();
                    continue;
                }
                
                if(bead[0].x == bead[1].x && bead[0].y == bead[1].y) {
                    if(i == 0) {
                        bead[second].x++;
                    }
                    else
                        if(i == 1) {
                            bead[second].x--;
                        }
                        else
                            if(i == 2) {
                                bead[second].y++;
                            }
                            else
                                if(i == 3) {
                                    bead[second].y--;
                                }
                }
                map[bead[0].x][bead[0].y] = 'R';
                map[bead[1].x][bead[1].y] = 'B';
                game(count + 1);
                for(int a = 0; a < 2; a++)
                    bead[a] = new Bead(copyBead[a].x, copyBead[a].y);
                for(int a = 0; a < n; a++)
                    map[a] = copyMap[a].clone();
            }
        }
    }
    
    public static void move(int x, int y, int dir, int color) {
        if(map[x][y] == 'O'){
            bead[color].x = -1;
            bead[color].y = -1;
            return;
        }
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        
        if(check(nx, ny) && map[nx][ny] != '#') {
            bead[color].x = nx;
            bead[color].y = ny;
            move(nx, ny, dir, color);
        }
    }
    
    public static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
    
    static class Bead {
        int x, y;
        
        Bead(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
