import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10824 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
    
        int a = Integer.parseInt(stz.nextToken());
        int b = Integer.parseInt(stz.nextToken());
        int c = Integer.parseInt(stz.nextToken());
        int d = Integer.parseInt(stz.nextToken());
    
        long ab = Long.parseLong("" + a + b);
        long cd = Long.parseLong("" + c + d);
        System.out.println(ab+cd);
    }
}
