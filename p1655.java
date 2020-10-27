import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class p1655 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int mid;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < loop; i++) {
            int now = Integer.parseInt(br.readLine());
            if(i == 0) {
                mid = now;
                left.offer(now);
                sb.append(mid + "\n");
                continue;
            }
            mid = left.peek();
            if(now > mid)
                right.offer(now);
            else
                left.offer(now);
            
            if(right.size() > left.size())
                left.offer(right.poll());
            if(left.size() >= right.size() + 2)
                right.offer(left.poll());
            
            sb.append(left.peek() + "\n");
        }
    
        System.out.println(sb.toString());
    }
}
