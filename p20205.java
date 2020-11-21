import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p20205 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());
        int origin[][] = new int[n][n];
        int array[][] = new int[n*k][n*k];
        
        for(int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                origin[i][j] = Integer.parseInt(stz.nextToken());
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                
                for(int a = 0; a < k; a++) {
                    for(int b = 0; b < k; b++) {
                        array[k*i+a][k*j+b] = origin[i][j];
                    }
                }
                
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n*k; i++) {
            for(int j = 0; j < n*k; j++) {
                sb.append(array[i][j] + " ");
            }
            sb.append("\n");
        }
    
        System.out.println(sb.toString());
    }
}
