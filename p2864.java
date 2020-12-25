import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2864 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        String a = stz.nextToken();
        String b = stz.nextToken();
    
        int min = Integer.parseInt(a.replaceAll("6", "5")) + Integer.parseInt(b.replaceAll("6", "5"));
        int max = Integer.parseInt(a.replaceAll("5", "6")) + Integer.parseInt(b.replaceAll("5", "6"));
    
        System.out.println(min + " " + max);
    }
}
