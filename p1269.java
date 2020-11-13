import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class p1269 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int countA = Integer.parseInt(stz.nextToken());
        int countB = Integer.parseInt(stz.nextToken());
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        
        stz = new StringTokenizer(br.readLine());
        for(int i = 0; i < countA; i++) {
            int now = Integer.parseInt(stz.nextToken());
            a.add(now);
        }
        
        stz = new StringTokenizer(br.readLine());
        for(int i = 0; i < countB; i++) {
            int now = Integer.parseInt(stz.nextToken());
            b.add(now);
        }
        
        int count = 0;
        for(int num : a) {
            if(!b.contains(num))
                count++;
        }
        for(int num : b) {
            if(!a.contains(num))
                count++;
        }
    
        System.out.println(count);
    }
}
