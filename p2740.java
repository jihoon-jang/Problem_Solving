import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2740 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int a[][] = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++)
                a[i][j] = Integer.parseInt(stz.nextToken());
        }
        stz = new StringTokenizer(br.readLine());
        stz.nextToken();
        int k = Integer.parseInt(stz.nextToken());
        int b[][] = new int[m][k];
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < k; j++)
                b[i][j] = Integer.parseInt(stz.nextToken());
        }
    
        int result[][] = new int[n][k];
    
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++) {
                int value = 0;
                for(int l = 0; l < m; l++) {
                    value += a[i][l] * b[l][j];
                }
                result[i][j] = value;
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++)
                System.out.print(result[i][j] + " ");
            System.out.println();
        }
    }
}