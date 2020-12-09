import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2947 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int num[] = new int[5];
        for(int i = 0; i < 5; i++)
            num[i] = Integer.parseInt(stz.nextToken());
        StringBuilder sb = new StringBuilder();
        
        while(Arrays.compare(num, new int[] {1,2,3,4,5}) != 0) {
            boolean change = false;
            for(int j = 0; j < 4; j++) {
                if(num[j] > num[j+1]) {
                    change = true;
                    swap(j, j+1, num);
                    if(change){
                        for(int n : num)
                            sb.append(n + " ");
                        sb.append("\n");
                        change = false;
                    }
                }
            }
        }
    
        System.out.println(sb.toString());
    }
    
    public static void swap(int n1, int n2, int num[]) {
        int temp = num[n2];
        num[n2] = num[n1];
        num[n1] = temp;
    }
}
