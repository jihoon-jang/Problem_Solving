import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2420 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        long n1 = Long.parseLong(stz.nextToken());
        long n2 = Long.parseLong(stz.nextToken());
        System.out.println(Math.abs(n1 - n2));
    }
}
