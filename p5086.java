import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p5086 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n1 = Integer.parseInt(s[0]);
        int n2 = Integer.parseInt(s[1]);
        
        while(!(n1 == 0 && n2 == 0)){
            String answer = "";
            if(n2 % n1 == 0)
                answer = "factor";
            
            if(n1 % n2 == 0)
                answer = "multiple";
            
            System.out.println(answer.length() == 0 ? "neither" : answer);
            s = br.readLine().split(" ");
            n1 = Integer.parseInt(s[0]);
            n2 = Integer.parseInt(s[1]);
        }
    }
}
