import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class p10867 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new TreeSet<>();
        StringTokenizer stz = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++)
            set.add(Integer.parseInt(stz.nextToken()));
        
        StringBuilder sb = new StringBuilder();
        for(int number : set)
            sb.append(number + " ");
        System.out.println(sb.toString());
    }
}
