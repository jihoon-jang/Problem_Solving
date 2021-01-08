import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15969 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int max = 0;
        int min = 987654321;
        
        for(int i = 0; i < n; i++) {
            int number = Integer.parseInt(stz.nextToken());
            max = Math.max(max, number);
            min = Math.min(min, number);
        }
    
        System.out.println(max-min);
    }
}
