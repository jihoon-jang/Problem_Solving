import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p1132 {
    
    static Map<Character, Long> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Character> first = new ArrayList<>();
        for(int i = 0; i < 10; i ++)
            first.add((char)('A'+i));
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            divide(input);
            if(first.contains(input.charAt(0)))
                first.remove(first.indexOf(input.charAt(0)));
        }
        ArrayList<Character> al = new ArrayList<>(map.keySet());
        long answer = 0;
        if(map.size() == 10) {
            Collections.sort(first, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return map.get(o2).compareTo(map.get(o1));
                }
            });
            al.remove(first.get(first.size()-1));
        }
        Collections.sort(al, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        int number = 9;
        for(char c : al) {
            long value = map.get(c);
            answer += value*number;
            number--;
        }
        System.out.println(answer);
    }
    
    public static void divide(String input) {
        int length = input.length();
        for(int i = 0; i < length; i++) {
            char c = input.charAt(i);
            int e = length-1-i;
            
            if(map.containsKey(c))
                map.put(c, map.get(c)+(long)Math.pow(10,e));
            else
                map.put(c, (long)Math.pow(10,e));
        }
    }
}
