import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2525 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int time = Integer.parseInt(br.readLine());
    
        m += time;
        h += m/60;
        m %= 60;
        while(h >= 24)
            h -=24;
    
        System.out.println(h + " "+ m);
    }
}
