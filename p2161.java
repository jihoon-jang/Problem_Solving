import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p2161 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            q.offer(i);
        }
        
        while(q.size() > 1) {
            sb.append(q.poll() + " ");
            q.offer(q.poll());
        }
    
        System.out.println(sb.toString() + q.poll());
    }
}
