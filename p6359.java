import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p6359 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        
        while(loop --> 0) {
            int n = Integer.parseInt(br.readLine());
            boolean room[] = new boolean[n+1];
            Arrays.fill(room, true);
            
            for(int i = 2; i <= n; i++) {
                for(int j = 1; j * i <= n; j++) {
                    if(room[i*j])
                        room[j*i] = false;
                    else
                        room[i*j] = true;
                }
            }
            int count = 0;
            for(int i = 1; i <= n; i++)
                if(room[i])
                    count++;
    
            System.out.println(count);
        }
    }
}
