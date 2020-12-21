import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int numbers[] = new int[n];
        int sum[] = new int[n];
        stz = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stz.nextToken());
            if(i == 0)
                sum[i] = numbers[i];
            else
                sum[i] = sum[i-1] + numbers[i];
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stz.nextToken())-1;
            int end = Integer.parseInt(stz.nextToken())-1;
            sb.append(sum[end]-sum[start]+numbers[start]).append("\n");
        }
    
        System.out.print(sb.toString());
    }
}
