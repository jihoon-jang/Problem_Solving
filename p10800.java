import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p10800 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int n = Integer.parseInt(br.readLine());
        Ball ball[] = new Ball[n];
        for(int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(stz.nextToken());
            int size = Integer.parseInt(stz.nextToken());
            ball[i] = new Ball(i, color, size);
        }
        Arrays.sort(ball);
        int sum[] = new int[n+1];
        int answer[] = new int[n];
        int total = 0;
        Queue<Ball> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            Ball now = ball[i];
            if(!q.isEmpty() && now.size != q.peek().size) {
                Queue<Ball> q2 = new LinkedList<>();
                while(!q.isEmpty()){
                    Ball b = q.poll();
                    answer[b.number] = total - sum[b.color];
                    q2.offer(b);
                }
                while(!q2.isEmpty()) {
                    Ball b = q2.poll();
                    sum[b.color] += b.size;
                    total += b.size;
                }
                answer[now.number] = total - sum[now.color];
            }
            
            q.offer(now);
        }
        while(!q.isEmpty()){
            Ball b = q.poll();
            answer[b.number] = total - sum[b.color];
        }
        StringBuilder sb = new StringBuilder();
        for(int i : answer)
            sb.append(i + "\n");
        System.out.println(sb.toString());
    }
    
    static class Ball implements Comparable<Ball>{
        int number, color, size;
        
        Ball(int n, int c, int s) {
            this.number = n;
            this.color = c;
            this.size = s;
        }
        
        public int compareTo(Ball o) {
            return size-o.size;
        }
    }
}
