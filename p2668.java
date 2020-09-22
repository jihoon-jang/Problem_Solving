import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class p2668 {
    
    static boolean visit[];
    static Set<Integer> answer = new TreeSet<>();
    static int array[];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        array = new int[n+1];
        visit = new boolean[n+1];
        for(int i = 1; i <= n; i++)
            array[i] = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= n; i++){
            boolean copy[] = visit.clone();
            Set<Integer> tempSet = new TreeSet<>(answer);
            Set<Integer> indexSet = new TreeSet<>();
            Set<Integer> valueSet = new TreeSet<>();
            if(!visit[i])
                dfs(i, indexSet, valueSet);
            if(!indexSet.equals(valueSet)){
                visit = copy.clone();
                answer = new TreeSet<>(tempSet);
            }
        }
        
        System.out.println(answer.size());
        Iterator<Integer> it = answer.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }
    
    public static void dfs(int index, Set<Integer> indexSet, Set<Integer> valueSet) {
        visit[index] = true;
        indexSet.add(index);
        valueSet.add(array[index]);
        answer.add(index);
        if(!visit[array[index]])
            dfs(array[index], indexSet, valueSet);
    }
}
