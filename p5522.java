import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p5522 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        
        for(int i = 0; i < 5; i++) {
            answer += Integer.parseInt(br.readLine());
        }
    
        System.out.println(answer);
    }
}
