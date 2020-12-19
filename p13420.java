import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p13420 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(tc --> 0) {
            stz = new StringTokenizer(br.readLine());
            long n1 = Long.parseLong(stz.nextToken());
            char operation = stz.nextToken().charAt(0);
            long n2 = Long.parseLong(stz.nextToken());
            stz.nextToken();
            long n3 = Long.parseLong(stz.nextToken());
            long result = 0;
            
            switch(operation) {
                case '+' :
                    result = n1 + n2;
                    break;
                case '-' :
                    result = n1 - n2;
                    break;
                case '*' :
                    result = n1 * n2;
                    break;
                case '/' :
                    result = n1 / n2;
                    break;
            }
            
            if(n3 == result)
                sb.append("correct").append("\n");
            else
                sb.append("wrong answer").append("\n");
        }
    
        System.out.println(sb.toString());
    }
}
