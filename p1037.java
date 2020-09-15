import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1037 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int number[] = new int[n];
        StringTokenizer stz = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            number[i] = Integer.parseInt(stz.nextToken());
        Arrays.sort(number);
        System.out.println(number[0]*number[number.length-1]);
    }
}
