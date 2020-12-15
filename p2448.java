import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2448 {
    
    static char map[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new char[n][2*n-1];
        for(int i = 0; i < n; i++)
            Arrays.fill(map[i], ' ');
        
        star(n, 0, 0);
        System.out.print(print());
    }
    
    public static void star(int size, int x, int y) {
        if(size == 3) {
            map[x][y+2] = '*';
            map[x+1][y+1] = '*';
            map[x+1][y+3] = '*';
            for(int i = 0; i < 5; i++)
                map[x+2][y+i] = '*';
            return;
        }
        
        star(size/2, x, y + size/2);
        star(size/2, x + size/2, y);
        star(size/2, x + size/2, y + size);
    }
    
    public static String print(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < 2*map.length-1; j++) {
                sb.append(map[i][j]);
            }
            if(i != map.length-1)
                sb.append("\n");
        }
        
        return sb.toString();
    }
}