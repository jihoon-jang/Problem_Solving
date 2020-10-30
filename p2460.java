import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2460 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int max = 0;
        int train = 0;
        
        for(int i = 0; i < 10; i++) {
            stz = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(stz.nextToken());
            int in = Integer.parseInt(stz.nextToken());
            train -= out;
            train += in;
            if(train > 10000)
                train = 10000;
            max = Math.max(max, train);
        }
        
        System.out.println(max);
    }
}
