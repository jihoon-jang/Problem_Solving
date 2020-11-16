import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class p10987 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('u');
        set.add('o');
        int count = 0;
        String input = br.readLine();
        for(int i = 0; i < input.length(); i++)
            if(set.contains(input.charAt(i)))
                count ++;
    
        System.out.println(count);
    }
}
