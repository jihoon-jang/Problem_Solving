import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10810 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int backet[] = new int[n+1];
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stz.nextToken());
            int end = Integer.parseInt(stz.nextToken());
            int value = Integer.parseInt(stz.nextToken());
            
            for(int j = start; j <= end; j++)
                backet[j] = value;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= n; i++)
            sb.append(backet[i] + " ");
    
        System.out.println(sb.toString());
    }
}
