import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class p11004 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());
        int array[] = new int[n];
        stz = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            array[i] = Integer.parseInt(stz.nextToken());
        Arrays.sort(array);
        System.out.println(array[k-1]);
    }
}
