import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p2752 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < 3; i++)
            list.add(Integer.parseInt(stz.nextToken()));
        Collections.sort(list);
        
        for(int i : list)
            System.out.print(i + " ");
    }
}
