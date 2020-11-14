import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class p2750 {
    //treeset을 이용해 중복 제거 + 정렬
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new TreeSet<>();
        
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++)
            set.add(Integer.parseInt(br.readLine()));
        StringBuilder sb = new StringBuilder();
        
        for(int i : set)
            sb.append(i + "\n");
        System.out.println(sb.toString());
    }
}
