import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2566 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int x = 0, y = 0, value = 0;
        
        for(int i = 0; i < 9; i++) {
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                int n = Integer.parseInt(stz.nextToken());
                if(value < n) {
                    x = i+1;
                    y = j+1;
                    value = n;
                }
            }
        }
    
        System.out.println(value + "\n" + x + " " + y);
    }
}
