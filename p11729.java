import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p11729 {
    
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
    
        sb.append((int)(Math.pow(2, n)-1)).append("\n");
        hanoi(n, 1, 2, 3);
        System.out.println(sb.toString());
    }
    
    public static void hanoi(int n, int start, int mid, int end) {
        if(n == 1) {
            sb.append(start + " " + end + "\n");
            return;
        }
        
        hanoi(n-1, start, end, mid);
        sb.append(start + " " + end + "\n");
        hanoi(n-1, mid, start, end);
    }
}
