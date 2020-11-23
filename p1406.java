import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p1406 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        String input = br.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for(int i = 0; i < input.length(); i++)
            left.push(input.charAt(i));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            char command = stz.nextToken().charAt(0);
            switch(command) {
                case 'L':
                    if(!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;
                case 'D':
                    if(!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;
                case 'B' :
                    if(!left.isEmpty())
                        left.pop();
                    break;
                case 'P':
                    left.push(stz.nextToken().charAt(0));
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!left.isEmpty())
            sb.append(left.pop());
    
        System.out.print(sb.reverse().toString());
        sb = new StringBuilder();
        while(!right.isEmpty())
            sb.append(right.pop());
        System.out.println(sb.toString());
    }
}
