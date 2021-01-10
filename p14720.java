import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14720 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int count = 0;
        int milk = 0;
        
        while(n --> 0) {
            int now = Integer.parseInt(stz.nextToken());
            if(milk == now) {
                count++;
                milk++;
                if(milk == 3)
                    milk = 0;
            }
        }
    
        System.out.println(count);
    }
}
