import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2304 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int height[] = new int[1000000];
        int min = 1000000;
        int max = 0;
        StringTokenizer stz;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(stz.nextToken())+1;
            int h = Integer.parseInt(stz.nextToken());
            sum += h;
            height[l] = h;
            min = Math.min(min, l);
            max = Math.max(max, l);
        }
        int answer = 0;
        
        for(int j = min; j <= max; j++) {
            int left = height[j-1], right = height[j+1];
            
            for(int i = j-1; i >= min; i--) {
                left = Math.max(left, height[i]);
            }
            for(int i = j+1; i <= max; i++) {
                right = Math.max(right, height[i]);
            }
            int max2 = Math.min(left, right);
            if(height[j] < max2){
                answer += max2-height[j];
                height[j] = max2;
            }
        }
        
        System.out.println(answer+sum);
    }
}
