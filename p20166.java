import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p20166 {
    
    static char map[][];
    static int n, m, k, answer;
    static Map<String, Integer> count;
    static LinkedList<String> list;
    static int dx[] = {-1,-1,0,1,1,1,0,-1};
    static int dy[] = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        answer = 0;
        count = new HashMap<>();
        map = new char[n][m];
        list = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();
        }
        for(int i = 0; i < k; i++){
            String word = br.readLine();
            list.add(word);
            count.put(word, 0);
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dfs(i, j, "" + map[i][j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s : list)
            sb.append(count.get(s) + "\n");
        System.out.println(sb.toString());
    }
    
    public static void dfs(int x, int y, String s) {
        if(count.containsKey(s))
            count.put(s, count.get(s)+1);
        
        if(s.length() == 5) {
            return;
        }
        
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= n)
                nx -= n;
            if(ny >= m)
                ny -= m;
            if(nx < 0)
                nx += n;
            if(ny < 0)
                ny += m;
            dfs(nx, ny, s+map[nx][ny]);
        }
    }
}
