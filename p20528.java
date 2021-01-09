import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p20528 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stz = new StringTokenizer(br.readLine());
        String word = stz.nextToken();
        char c = 'a';
        if(word.charAt(0) == word.charAt(word.length()-1))
            c = word.charAt(0);
        else {
            System.out.println(0);
            return;
        }
        
        for(int i = 0; i < n-1; i++) {
            word = stz.nextToken();
            char start = word.charAt(0);
            char end = word.charAt(word.length()-1);
            
            if(start == end && end == c) {}
            else {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
