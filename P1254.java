import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1254 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        for(int i = 0; i < line.length()-1; i++) {
            if(check(line.substring(i, line.length()))) {
                System.out.println(line.length() + i);
                return;
            }
        }
        System.out.println(2*line.length() -1);
    }
    
    public static boolean check(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
}
//abaaba