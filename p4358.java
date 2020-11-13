import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class p4358 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> tree = new TreeMap<>();
        int count = 0;
        
        String input = "";
        while((input = br.readLine()) != null) {
            if(tree.containsKey(input))
                tree.put(input, tree.get(input)+1);
            else
                tree.put(input, 1);
            count++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(String s : tree.keySet())
            sb.append(String.format("%s %.4f\n", s, (double)tree.get(s)/count*100));
        System.out.println(sb.toString());
    }
}
