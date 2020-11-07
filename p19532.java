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
    
        int lcm = lcm(a, d);
        int gcd = a/lcm * d;
        int n1 = gcd / a;
        int n2 = gcd / d;
        a *= n1;
        d *= n2;
        b *= n1;
        c *= n1;
        e *= n2;
        f *= n2;
        int x = 0;
        int y = 0;
        if(a == d) {
            a *= -1;
            b *= -1;
            c *= -1;
            b += e;
            c += f;
        }
    
        y = (c+f)/(b+e);
        x = (f - e*y)/d;
    
        System.out.println(x + " " + y);
    }
    
    public static int lcm(int n1, int n2) {
        if(n1 % n2 == 0)
            return n2;
        return lcm(n2, n1%n2);
    }
}
