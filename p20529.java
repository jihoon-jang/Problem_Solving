import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p20529 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(tc --> 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer stz = new StringTokenizer(br.readLine());
            String type[] = new String[n];
            for(int i = 0; i < n; i++)
                type[i] = stz.nextToken();
            int min = 987654321;
            a: for(int i = 0; i < n-2; i++) {
                for(int j = i+1; j < n-1; j++) {
                    for(int k = j+1; k < n; k++) {
                        int sum = getDiff(type[i], type[j]) + getDiff(type[j], type[k]) + getDiff(type[k], type[i]);
                        min = Math.min(sum, min);
                        if(min == 0)
                            break a;
                    }
                }
            }
            
            sb.append(min).append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    public static int getDiff(String s1, String s2) {
        int count = 0;
        
        for(int i = 0; i < 4; i++)
            if(s1.charAt(i) != s2.charAt(i))
                count++;
        
        return count;
    }
}