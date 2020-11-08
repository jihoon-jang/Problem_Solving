import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p19532 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(stz.nextToken());
        int b = Integer.parseInt(stz.nextToken());
        int c = Integer.parseInt(stz.nextToken());
        int d = Integer.parseInt(stz.nextToken());
        int e = Integer.parseInt(stz.nextToken());
        int f = Integer.parseInt(stz.nextToken());
    
        int x, y;
        
        for(x = -999; x <= 999; x++) {
            for(y = -999; y <= 999; y++) {
                if(a*x + b * y == c && d*x + e* y == f) {
                    System.out.println(x + " " +y);
                    return;
                }
            }
        }
    }
    
}
