import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class p9322 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            stz = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                String s = stz.nextToken();
                map.put(s, i);
            }
            int gap[] = new int[n];
            stz = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                String s = stz.nextToken();
                gap[i] = map.get(s)-i;
            }
            stz = new StringTokenizer(br.readLine());
            String answer[] = new String[n];
            for(int i = 0; i < n; i++) {
                String s = stz.nextToken();
                answer[i + gap[i]] = s;
            }
            StringBuilder sb = new StringBuilder();
            for(String s : answer)
                sb.append(s + " ");
            System.out.println(sb.toString());
        }
    }
}
