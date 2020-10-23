import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2512 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int array[] = new int[n];
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stz.nextToken());
            max = Math.max(max, array[i]);
        }
        int value = Integer.parseInt(br.readLine());
        
        int left = 0;
        int right = 100000;
        int mid;
        int answer = 0;
        
        while(left <= right) {
            mid = (left + right) / 2;
            int sum = 0;
            for(int i = 0; i < n; i++) {
                if(mid > array[i])
                    sum += array[i];
                else
                    sum += mid;
                if(sum > value)
                    break;
            }
            
            if(sum > value)
                right = mid-1;
            else {
                left = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
    
        System.out.println(answer == 100000 ? max : answer);
    }
}
