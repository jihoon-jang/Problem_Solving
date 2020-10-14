import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p1747 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean prime[] = new boolean[2000000];
        prime[1] = true;
        for(int i = 2; i < 1000000; i++) {
            for(int j = 2; i*j < 2000000; j++)
                prime[i*j] = true;
        }
        
        int answer = 0;
        int number = n;
        while(answer == 0) {
            if(!prime[number] && check(number)) {
                answer = number;
            }
            number++;
        }
        System.out.println(answer);
    }
    
    public static boolean check(int n) {
        String s = String.valueOf(n);
        
        for(int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
}
