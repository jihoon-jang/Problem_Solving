import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p18808 {
    
    static int n, m, map[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());
        map = new int[n][m];
        
        for(int i = 0; i < k; i++) {
            stz = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(stz.nextToken());
            int c = Integer.parseInt(stz.nextToken());
            int sticker[][] = new int[r][c];
            for(int a = 0; a < r; a++) {
                stz = new StringTokenizer(br.readLine());
                for(int b = 0; b < c; b++)
                    sticker[a][b] = Integer.parseInt(stz.nextToken());
            }
            
            for(int j = 0; j < 4; j++) {
                if(putSticker(r, c, sticker))
                    break;
                int rotatedSticker[][] = new int[c][r];
                for(int a = 0; a < r; a++) {
                    for(int b = 0; b < c; b++) {
                        rotatedSticker[b][r-1-a] = sticker[a][b];
                    }
                }
                r = c;
                c = rotatedSticker[0].length;
                sticker = rotatedSticker;
            }
        }
    
        System.out.println(count());
    }
    
    public static boolean putSticker(int r, int c, int sticker[][]) {
        //세로
        for(int i = 0; i+r <= n; i++) {
            //가로
            l : for(int j = 0; j+c <= m; j++) {
                
                //스티커 검사
                for(int a = 0; a < r; a++) {
                    for(int b = 0; b < c; b++) {
                        if(sticker[a][b] == 1 && map[i+a][j+b] == 1)
                            continue l;
                    }
                }
                for(int a = 0; a < r; a++) {
                    for(int b = 0; b < c; b++)
                        if(sticker[a][b] == 1)
                            map[i+a][j+b] = sticker[a][b];
                }
                return true;
            }
        }
        
        return false;
    }
    
    public static int count() {
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++)
                if(map[i][j] == 1)
                    count++;
        }
        
        return count;
    }
}
