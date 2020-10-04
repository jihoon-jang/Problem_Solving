import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1009 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer stz;
        StringBuilder sb = new StringBuilder();
        
        for(int l = 0; l < tc; l++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            
            int num = 1;
            for(int i = 1; i <= b; i++){
                num *= a;
                num %= 10;
            }
            sb.append((num == 0 ? 10 : num)+ (l != tc-1 ? "\n" : ""));
        }
        System.out.println(sb.toString());
    }
}
