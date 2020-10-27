import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p1213 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int alphabet[] = new int[26];
        for(int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            alphabet[c-'A']++;
        }
        int odd = 0;
        for(int i = 0; i < 26; i++) {
            if(alphabet[i] % 2 == 1)
                odd++;
        }
        if(odd > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        char c = '@';
        for(int i = 0; i < 26; i++) {
            if(alphabet[i] % 2 == 1)
                c = (char) (i+'A');
            for(int j = 0; j < alphabet[i]/2; j++) {
                sb.append((char)(i+'A'));
            }
        }
        System.out.println(sb.toString() + (c != '@' ? c : "") + sb.reverse().toString());
    }
}
