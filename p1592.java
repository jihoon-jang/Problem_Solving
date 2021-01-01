import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1592 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int l = Integer.parseInt(stz.nextToken());
        
        int now = 1;
        int count[] = new int[n+1];
        int answer = 0;
        count[1] = 1;
        
        while(true) {
            int value = count[now];
            
            if(value == m)
                break;
            
            if(value % 2 == 1) {
                now += l;
                if(now > n)
                    now -= n;
            }
            else {
                now -= l;
                if(now < 1)
                    now += n;
            }
            count[now]++;
            answer++;
        }
    
        System.out.println(answer);
    }
}
