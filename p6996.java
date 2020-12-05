import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p6996 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        l : while(tc --> 0) {
            stz = new StringTokenizer(br.readLine());
            String s1 = stz.nextToken();
            String s2 = stz.nextToken();
            
            if(s1.length() != s2.length())
                sb.append(s1).append(" & ").append(s2).append(" are NOT anagrams.\n");
            else {
                char c1[] = s1.toCharArray();
                char c2[] = s2.toCharArray();
                int n = c1.length;
                Arrays.sort(c1);
                Arrays.sort(c2);
                for(int i = 0; i < n; i++) {
                    if(c1[i] != c2[i]) {
                        sb.append(s1).append(" & ").append(s2).append(" are NOT anagrams.\n");
                        continue l;
                    }
                }
                sb.append(s1).append(" & ").append(s2).append(" are anagrams.\n");
            }
        }
    
        System.out.println(sb.toString());
    }
}
