import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p10825 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        PriorityQueue<Student> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        
        while(n --> 0) {
            stz = new StringTokenizer(br.readLine());
            String name = stz.nextToken();
            int kor = Integer.parseInt(stz.nextToken());
            int eng = Integer.parseInt(stz.nextToken());
            int math = Integer.parseInt(stz.nextToken());
            
            pq.offer(new Student(name, kor, eng, math));
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Student now = pq.poll();
            
            sb.append(now.name).append("\n");
        }
    
        System.out.println(sb.toString());
    }
    
    static class Student implements Comparable<Student> {
        String name;
        int kor, eng, math;
        
        Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    
        @Override
        public int compareTo(Student o) {
            if(kor == o.kor) {
                if(eng == o.eng) {
                    if(math == o.math) {
                        return name.compareTo(o.name);
                    }
                    return o.math - math;
                }
                return eng - o.eng;
            }
            return o.kor-kor;
        }
    }
}
