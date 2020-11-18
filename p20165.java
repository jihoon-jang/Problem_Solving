import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p20165 {
    
    static int map[][], score, n, m;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static Map<String, Integer> bearing;
    static boolean die[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        int r = Integer.parseInt(stz.nextToken());
        map = new int[n][m];
        die = new boolean[n][m];
        score = 0;
        bearing = new HashMap<>();
        bearing.put("N", 0);
        bearing.put("S", 1);
        bearing.put("W", 2);
        bearing.put("E", 3);
        for(int i = 0; i < n; i++){
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(stz.nextToken());
        }
        
        for(int i = 0; i < r; i++) {
            stz = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stz.nextToken())-1;
            int y = Integer.parseInt(stz.nextToken())-1;
            int d = bearing.get(stz.nextToken());
            if(!die[x][y])
                attack(x, y, d);
            stz = new StringTokenizer(br.readLine());
            x = Integer.parseInt(stz.nextToken())-1;
            y = Integer.parseInt(stz.nextToken())-1;
            die[x][y] = false;
        }
        System.out.println(score + "\n" + print());
    }
    
    public static void attack(int x, int y, int d) {
        Queue<Domino> q = new LinkedList<>();
        q.offer(new Domino(x, y, map[x][y]));
        
        while(!q.isEmpty()) {
            Domino now = q.poll();
            for(int i = 0; i < now.len; i++) {
                int nx = now.x + dx[d]*i;
                int ny = now.y + dy[d]*i;
                if(check(nx, ny) && !die[nx][ny]) {
                    die[nx][ny] = true;
                    score ++;
                    q.offer(new Domino(nx, ny, map[nx][ny]));
                }
            }
        }
    }
    
    public static boolean check(int x, int y) {
        return x >= 0 && y >=  0 && x < n && y < m;
    }
    
    public static String print() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(die[i][j] ? "F " : "S ");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
    static class Domino{
        int x, y, len;
        
        Domino(int x, int y, int l) {
            this.x = x;
            this.y = y;
            len = l;
        }
    }
}
