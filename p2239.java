import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p2239 {
    
    static int map[][];
    static boolean finish;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        finish = false;
        for(int i = 0; i < 9; i++) {
            String input = br.readLine();
            for(int j = 0; j < 9; j++)
                map[i][j] = input.charAt(j) - '0';
        }
        dfs(0, 0);
    }
    
    public static void dfs(int x, int y) {
        if(!finish) {
            if(y == 9) {
                y = 0;
                x++;
            }
            if(x == 9) {
                finish = true;
                for(int i = 0; i < 9; i++) {
                    for(int j = 0; j < 9; j++) {
                        System.out.print(map[i][j]);
                    }
                    System.out.println();
                }
                return;
            }
            int copy[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
                copy[i] = map[i].clone();
            
            if(map[x][y] == 0) {
                for(int i = 1; i <= 9; i++) {
                    map[x][y] = i;
                    if(check(x, y)) {
                        dfs(x, y + 1);
                        for(int a = 0; a < 9; a++)
                            map[a] = copy[a].clone();
                    }
                }
            }
            else
                dfs(x, y+1);
        }
    }
    
    public static boolean check(int x, int y) {
        boolean num[] = new boolean[10];
        for(int i = 0; i < 9; i++) {
            int n = map[x][i];
            if(!num[n])
                num[n] = true;
            else if(num[n] && n != 0)
                return false;
        }
        
        num = new boolean[10];
        for(int i = 0; i < 9; i++) {
            int n = map[i][y];
            if(!num[n])
                num[n] = true;
            else if(num[n] && n != 0)
                return false;
        }
        int nx = 3*(x/3);
        int ny = 3*(y/3);
        num = new boolean[10];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                int n = map[nx+i][ny+j];
                if(!num[n])
                    num[n] = true;
                else if(num[n] && n != 0)
                    return false;
            }
        }
        
        return true;
    }
}
