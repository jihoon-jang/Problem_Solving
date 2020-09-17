import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10253 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int tc = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < tc; t++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            
            while(a != 1) {
                int count;
                if(b % a != 0)
                    count = b/a+1;
                else
                    count = b/a;
                a = a*count - b;
                b *= count;
                int value = gcd(b, a);
                a /= value;
                b /= value;
            }
            System.out.println(b);
        }
    }
    
    public static int gcd(int n1, int n2) {
        if(n1 % n2 == 0)
            return n2;
        return gcd(n2, n1 % n2);
    }
}
