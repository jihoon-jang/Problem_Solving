import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p1212 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String convert[] = {"000", "001", "010", "011", "100", "101", "110", "111"};
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        for(int i = 0; i < input.length(); i++) {
            int n = input.charAt(i) - '0';
            if(i == 0)
                sb.append(Integer.parseInt(convert[n]));
            else
                sb.append(convert[n]);
        }
        
        System.out.println((sb.toString()));
    }
}
