import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p16197 {
    
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static char map[][];
    static Coin coin[];
    static int n, m, answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        answer = 987654321;
        map = new char[n][m];
        coin = new Coin[2];
        
        int index = 0;
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'o')
                    coin[index++] = new Coin(i, j);
            }
        }
        
        move(1);
        System.out.println(answer == 987654321 ? -1 : answer);
    }
    
    public static void print() {
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j++)
                System.out.print(map[i][j] + "");
            System.out.println();
        }
        System.out.println();
    }
    
    public static void move(int count) {
        if(count >= answer || count == 11)
            return;
        Coin copyCoin[] = new Coin[2];
        for(int a = 0; a < 2; a++)
            copyCoin[a] = new Coin(coin[a].x, coin[a].y);
        char copyMap[][] = new char[n][m];
        for(int a = 0; a < n; a++)
            copyMap[a] = map[a].clone();
        
        //4방향
        for(int i = 0; i < 4; i++) {
            int out = 0;
            //동전 2개 움직임
            for(int j = 0; j < 2; j++) {
                int nx = coin[j].x + dx[i];
                int ny = coin[j].y + dy[i];
                map[coin[j].x][coin[j].y] = '.';
              
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    coin[j].x = -1;
                    coin[j].y = -1;
                    out++;
                }
                else if(map[nx][ny] != '.') {
                    map[coin[j].x][coin[j].y] = 'o';
                    continue;
                }
                else {
                    coin[j].x = nx;
                    coin[j].y = ny;
                    map[nx][ny] = 'o';
                }
            }
            
            if(out == 1)
                answer = Math.min(answer, count);
            else if(out == 2);
            else
                move(count+1);
    
            for(int a = 0; a < 2; a++)
                coin[a] = new Coin(copyCoin[a].x, copyCoin[a].y);
            for(int a = 0; a < n; a++)
                map[a] = copyMap[a].clone();
        }
    }
    
    static class Coin{
        int x, y;
        
        Coin(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
