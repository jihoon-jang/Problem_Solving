import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2506 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int n = Integer.parseInt(br.readLine());
        stz = new StringTokenizer(br.readLine());
        
        int score = 0;
        int before = 0;
        
        for(int i = 0; i < n; i++) {
            int correct = Integer.parseInt(stz.nextToken());
            
            if(correct == 1) {
                before++;
                score += before;
            }
            else
                before = 0;
        }
    
        System.out.println(score);
    }
}
