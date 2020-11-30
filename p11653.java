import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p11653 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int index = 2;
        
        while(n != 1) {
            if(n % index == 0) {
                n /= index;
                sb.append(index).append('\n');
                continue;
            }
            index++;
        }
        System.out.println(sb.toString());
    }
}
