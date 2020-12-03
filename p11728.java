import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11728 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int c[] = new int[n+m];
        stz = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++)
            c[i] = Integer.parseInt(stz.nextToken());
        stz = new StringTokenizer(br.readLine());
        for(int i = n; i < n+m; i++)
            c[i] = Integer.parseInt(stz.nextToken());
        Arrays.sort(c);
        StringBuilder sb = new StringBuilder();
        
        for(int i : c)
            sb.append(i + " ");
        System.out.println(sb.toString());
    }
}
