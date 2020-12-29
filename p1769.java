import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p1769  {
    
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int result;
        if(input.length() == 1)
            result = Integer.parseInt(input);
        else
            result = Integer.parseInt(convert(input));
        System.out.println(count);
        if(result%3 == 0)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    
    public static String convert(String s) {
        count++;
        long number = 0;
        
        for(int i = 0; i < s.length(); i++)
            number += s.charAt(i) - '0';
        
        if(number < 10)
            return String.valueOf(number);
        else
            return convert(String.valueOf(number));
    }
}
