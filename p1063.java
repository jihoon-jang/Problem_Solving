import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class p1063 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        Map<String, int[]> map = new HashMap<>();
        map.put("R", new int[] {0, 1});
        map.put("L", new int[] {0, -1});
        map.put("B", new int[] {-1, 0});
        map.put("T", new int[] {1, 0});
        map.put("RT", new int[] {1, 1});
        map.put("LT", new int[] {1, -1});
        map.put("RB", new int[] {-1, 1});
        map.put("LB", new int[] {-1, -1});
        
        int kx, ky, sx, sy;
        String king = stz.nextToken();
        ky = king.charAt(0) - 'A';
        kx = king.charAt(1) - '1';
        String stone = stz.nextToken();
        sy = stone.charAt(0) - 'A';
        sx = stone.charAt(1) - '1';
        
        int loop = Integer.parseInt(stz.nextToken());
        
        while(loop --> 0) {
            String command = br.readLine();
            int move[] = map.get(command);
            int nx = kx + move[0];
            int ny = ky + move[1];
            int mx = sx + move[0];
            int my = sy + move[1];
            
            if(nx == sx && ny == sy) {
                if(check(nx, ny) && check(mx, my)) {
                    kx = nx;
                    ky = ny;
                    sx = mx;
                    sy = my;
                }
            }
            else {
                if(check(nx, ny)) {
                    kx = nx;
                    ky = ny;
                }
            }
        }
        System.out.println((char)(ky+'A') + "" + (kx+1) + "\n" + (char)(sy+'A') + "" + (sx+1));
    }
    
    public static boolean check(int x, int y) {
        return x >= 0 && x <= 7 && y >= 0 && y <= 7;
    }
}