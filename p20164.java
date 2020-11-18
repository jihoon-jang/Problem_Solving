import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p20164 {
    
    static int min = 987654321, max = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        
        cal(number, 0);
    
        System.out.println(min + " " + max);
    }
    
    public static void cal(String num, int count) {
        int odd = 0;
        for(int i = 0; i < num.length(); i++){
            int n = num.charAt(i)-'0';
            if(n % 2 == 1)
                odd++;
        }
        if(num.length() == 1) {
            max = Math.max(max, count+odd);
            min = Math.min(min, count+odd);
            return;
        }
        else if(num.length() == 2)
            cal(String.valueOf(Integer.parseInt(num.substring(0, 1))+Integer.parseInt(num.substring(1, 2))), count + odd);
        else if(num.length() >= 3)
            for(int i = 1; i <= num.length()-2; i++) {
                for(int j = i+1; j <= num.length()-1; j++) {
                    int n1 = Integer.parseInt(num.substring(0, i));
                    int n2 = Integer.parseInt(num.substring(i, j));
                    int n3 = Integer.parseInt(num.substring(j, num.length()));
                    cal(String.valueOf(n1+n2+n3), count + odd);
                }
            }
    }
}
