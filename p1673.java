import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1673 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        String input;
        StringBuilder sb = new StringBuilder();
        while((input = br.readLine()) != null) {
            stz = new StringTokenizer(input);
            int n = Integer.parseInt(stz.nextToken());
            int k = Integer.parseInt(stz.nextToken());
            int count = n;
            while(n >= k) {
                int change = n / k;
                count += change;
                n %= k;
                n += change;
            }
            sb.append(count + "\n");
        }
        System.out.println(sb.toString());
    }
}
