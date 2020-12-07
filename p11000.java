import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p11000 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int tc = Integer.parseInt(br.readLine());
        PriorityQueue<Time> input = new PriorityQueue<>(new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if(o1.start == o2.start)
                    return o1.end-o2.end;
                return o1.start-o2.start;
            }
        });
        
        while(tc --> 0) {
            stz = new StringTokenizer(br.readLine());
            input.offer(new Time(Integer.parseInt(stz.nextToken()), Integer.parseInt(stz.nextToken())));
        }
        
        PriorityQueue<Integer> lec = new PriorityQueue<>();
        while(!input.isEmpty()) {
            Time now = input.poll();
            
            if(!lec.isEmpty() && lec.peek() <= now.start)
                lec.poll();
            
            lec.offer(now.end);
        }
    
        System.out.println(lec.size());
    }
    
    static class Time{
        int start, end;
        
        Time(int s, int e) {
            start = s;
            end = e;
        }
    }
}
