import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2745 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        String input = stz.nextToken();
        int b = Integer.parseInt(stz.nextToken());
        int result = 0;
        
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(input.length()-1-i);
    
            if(c >= '0' && c <= '9') {
                result += (c-'0') * Math.pow(b, i);
            }
            else {
                int value = (c - 'A')+10;
                result += value * Math.pow(b, i);
            }
        }
    
        System.out.println(result);
    }
}
