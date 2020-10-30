import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10813 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int array[] = new int[n+1];
        for(int i = 0; i <=n; i++)
            array[i] = i;
        
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
        
        for(int i = 1;  i <= n; i++)
            System.out.print(array[i] + " ");
    }
}
