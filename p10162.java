import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p10162 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int a = t/300;
        t %= 300;
        int b = t/60;
        t %= 60;
        int c = t/10;
        t %= 10;
        
        if(t != 0)
            System.out.println(-1);
        else
            System.out.println(a + " "+ b + " " +c);
    }
}
