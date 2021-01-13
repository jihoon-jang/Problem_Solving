import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1292 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int number = 1;
        int array[] = new int[1001];
        int index = 1;
        
        for(; index <= 1000; number++) {
            for(int i = 0; i < number && index <= 1000; i++) {
                array[index++] = number;
            }
        }
        
        int start = Integer.parseInt(stz.nextToken());
        int end = Integer.parseInt(stz.nextToken());
        
        int sum = 0;
        for(int i = start; i <= end; i++)
            sum += array[i];
    
        System.out.println(sum);
    }
}
