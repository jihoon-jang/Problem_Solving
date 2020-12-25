import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p7567 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char before = input.charAt(0);
        int height = 10;
        
        for(int i = 1; i < input.length(); i++) {
            char now = input.charAt(i);
            
            if(before == now)
                height += 5;
            else {
                before = now;
                height += 10;
            }
        }
    
        System.out.println(height);
    }
}
