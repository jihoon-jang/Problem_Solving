import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3184 {
    
    static int r, c, wolf, sheep, countSheep, countWolf;
    static char map[][];
    static boolean visit[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        r = Integer.parseInt(stz.nextToken());
        c = Integer.parseInt(stz.nextToken());
        map = new char[r][c];
        visit = new boolean[r][c];
        
        for(int i = 0; i < r; i++) {
            String line = br.readLine();
            for(int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'v')
                    wolf++;
                else if(map[i][j] == 'o')
                    sheep++;
            }
        }
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(!visit[i][j] && map[i][j] != '#') {
                    countSheep = 0;
                    countWolf = 0;
                    visit[i][j] = true;
                    dfs(i, j);
                    if(countSheep > countWolf)
                        wolf -= countWolf;
                    else
                        sheep -= countSheep;
                }
            }
        }
    
        System.out.println(sheep + " " + wolf);
    }
    
    public static void dfs(int x, int y) {
        if(map[x][y] == 'v')
            countWolf++;
        else if(map[x][y] == 'o')
            countSheep++;
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(check(nx, ny) && !visit[nx][ny] && map[nx][ny] != '#') {
                visit[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
    
    public static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < r && y < c;
    }
}
