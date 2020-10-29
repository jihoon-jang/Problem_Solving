import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14719 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(stz.nextToken());
        int w = Integer.parseInt(stz.nextToken());
        int rain[] = new int[w+2];
        stz = new StringTokenizer(br.readLine());
        for(int i = 1; i <= w; i++)
            rain[i] = Integer.parseInt(stz.nextToken());
        
        int answer = 0;
        
        for(int i = 1; i <= w; i++) {
            int left = i-1;
            int right = i+1;
    
            for(int j = left; j >= 1; j--) {
                if(rain[left] < rain[j])
                    left = j;
            }
            for(int j = right; j <= w; j++) {
                if(rain[right] < rain[j])
                    right = j;
            }
            int value = Math.min(rain[left], rain[right]);
            if(value > rain[i])
                answer += value - rain[i];
        }
    
        System.out.println(answer);
    }
}
