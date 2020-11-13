import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class p2776 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();
            stz = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++)
                set.add(Integer.parseInt(stz.nextToken()));
            int m = Integer.parseInt(br.readLine());
            stz = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++) {
                int now = Integer.parseInt(stz.nextToken());
                if(set.contains(now))
                    sb.append(1 + "\n");
                else
                    sb.append(0 + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
