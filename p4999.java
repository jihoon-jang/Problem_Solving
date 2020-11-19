import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p4999 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = br.readLine().length();
        int n2 = br.readLine().length();
        if(n1 < n2)
            System.out.println("no");
        else
            System.out.println("go");
    }
}
