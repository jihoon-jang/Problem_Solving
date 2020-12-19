import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p10822 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String array[] = input.split(",");
        int answer = 0;
        for(String num : array)
            answer += Integer.parseInt(num);
    
        System.out.println(answer);
    }
}
