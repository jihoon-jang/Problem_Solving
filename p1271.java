import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class p1271 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        BigInteger n = new BigInteger(stz.nextToken());
        BigInteger m = new BigInteger(stz.nextToken());
        System.out.println(n.divide(m));
        System.out.println(n.subtract(n.divide(m).multiply(m)));
    }
}
