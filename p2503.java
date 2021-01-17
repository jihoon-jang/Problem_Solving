import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class p2503 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        String baseball[] = new String[n];
        
        for(int i = 0; i < n; i++)
            baseball[i] = br.readLine();
        
        a : for(int i = 123; i <= 987; i++) {
            Set<Character> check = new HashSet<>();
            String number = String.format("%03d", i);
            for(int j = 0; j < 3; j++) {
                char temp = number.charAt(j);
                if(!check.contains(temp) && temp != '0')
                    check.add(temp);
                else {
                    continue a;
                }
            }
            if(compare(baseball, number)) {
                count++;
            }
        }
        System.out.println(count);
    }
    
    public static boolean compare(String baseball[], String number) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < 3; i++)
            set.add(number.charAt(i));
        
        for(int i = 0; i < baseball.length; i++) {
            StringTokenizer stz = new StringTokenizer(baseball[i]);
            String num = stz.nextToken();
            int strike = Integer.parseInt(stz.nextToken());
            int ball = Integer.parseInt(stz.nextToken()) + strike;
            int checkStrike = 0;
            int checkBall = 0;
            
            for(int j = 0; j < 3; j++) {
                if(num.charAt(j) == number.charAt(j))
                    checkStrike++;
                
                if(set.contains(num.charAt(j)))
                    checkBall++;
            }
            
            if(strike != checkStrike || ball != checkBall)
                return false;
        }
        
        return true;
    }
}
