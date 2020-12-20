import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p8595 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine()) + 1;
        String input = br.readLine() + "a";
        StringBuilder sb = new StringBuilder();
        long num = 0;
        
        for(int i = 0; i < length; i++) {
            char c = input.charAt(i);
            if(c >= '0' && c <= '9') {
                sb.append(c);
            }
            else {
                if(sb.toString().length() > 0) {
                    num += Long.parseLong(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
    
        System.out.println(num);
    }
}
