import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1783 {
    
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
    
        System.out.println(move());
    }
    
    public static int move() {
        if(n == 1)
            return 1;
        else if(n == 2)
            return Math.min(4, (m+1)/2);
        if(m < 7)
            return Math.min(4, m);
        
        return m-2;
    }
}
