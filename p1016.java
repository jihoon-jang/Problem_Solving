import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p1016 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number[] = br.readLine().split(" ");
        long min = Long.parseLong(number[0]);
        long max = Long.parseLong(number[1]);
        long count = max - min + 1;
        int answer = 0;
        long rt = (long) Math.floor(Math.sqrt(max));
        boolean check[] = new boolean[(int) count];
    
        for(long i = 2; i <= rt; i++) {
            long value = i*i;
            long start = (long)Math.ceil((double) min/value);
            for(long j = start; j*value <= max; j++)
                check[(int) ((j * value) - min)] = true;
        }
        
        for(int i = 0; i < count; i++)
            if(!check[i]) {
                answer++;
            }
        
        System.out.println(answer);
    }
}
