import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p10990 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= n; i++) {
            if(i == 1) {
                for(int j = 1; j < n; j++)
                    sb.append(' ');
                sb.append('*').append("\n");
            }
            else {
                for(int j = 0; j < n-i; j++)
                    sb.append(' ');
                sb.append('*');
                for(int j = 0; j < (i-1)*2 - 1; j++)
                    sb.append(' ');
                sb.append('*').append("\n");
            }
        }
    
        System.out.println(sb.toString());
    }
}
