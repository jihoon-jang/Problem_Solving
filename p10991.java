import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p10991 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= n; i++) {
            for(int j = n-i; j >= 1; j--)
                sb.append(" ");
            for(int j = 1; j <= i; j++) {
                sb.append("*");
                if(j != i)
                    sb.append(" ");
            }
            if(i != n)
                sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
