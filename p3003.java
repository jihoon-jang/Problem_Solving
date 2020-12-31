import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(stz.nextToken());
        int q = Integer.parseInt(stz.nextToken());
        int r = Integer.parseInt(stz.nextToken());
        int b = Integer.parseInt(stz.nextToken());
        int n = Integer.parseInt(stz.nextToken());
        int p = Integer.parseInt(stz.nextToken());
    
        System.out.print(1-k + " ");
        System.out.print(1-q+ " ");
        System.out.print(2-r+ " ");
        System.out.print(2-b+ " ");
        System.out.print(2-n+ " ");
        System.out.print(8-p+ " ");
    }
}
