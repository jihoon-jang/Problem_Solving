import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p17837 {
    
    static int n, k, map[][];
    static List<Integer> list[][];
    static Chip chip[];
    static int dx[] = {0,0,0,-1,1};
    static int dy[] = {0,1,-1,0,0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        map = new int[n+1][n+1];
        list = new LinkedList[n+1][n+1];
        chip = new Chip[k];
        for(int i = 1; i <= n; i++) {
            stz = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(stz.nextToken());
                list[i][j] = new LinkedList<>();
            }
        }
        for(int i = 0; i < k; i++){
            stz = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stz.nextToken());
            int y = Integer.parseInt(stz.nextToken());
            int d = Integer.parseInt(stz.nextToken());
            chip[i] = new Chip(x, y, d);
            list[x][y].add(i);
        }
        
        for(int i = 1; i <= 1001; i++) {
            if(i == 1001){
                System.out.println(-1);
                return;
            }
            if(move()) {
               System.out.println(i);
               return;
            }
        }
    }
    
    public static boolean move() {
        for(int i = 0; i < k; i++){
            Chip now = chip[i];
            int x = now.x + dx[now.direction];
            int y = now.y + dy[now.direction];
            int index = list[now.x][now.y].indexOf(i);
            List<Integer> tempList = new LinkedList<>(list[now.x][now.y].subList(index, list[now.x][now.y].size()));
            if(index != 0)
                list[now.x][now.y] = new LinkedList<>(list[now.x][now.y].subList(0, index));
            else
                list[now.x][now.y].clear();
            
            if(check(x, y) && map[x][y] == 0) {
                Iterator<Integer> it = tempList.iterator();
                while(it.hasNext()) {
                    int num = it.next();
                    chip[num].x = x;
                    chip[num].y = y;
                    list[x][y].add(num);
                }
                if(list[x][y].size() >= 4)
                    return true;
            }
            else if(check(x, y) && map[x][y] == 1) {
                Collections.reverse(tempList);
                Iterator<Integer> it = tempList.iterator();
                while(it.hasNext()) {
                    int num = it.next();
                    chip[num].x = x;
                    chip[num].y = y;
                    list[x][y].add(num);
                }
                if(list[x][y].size() >= 4)
                    return true;
            }
            else if(!check(x, y) || map[x][y] == 2) {
                    if(now.direction == 1)
                        now.direction = 2;
                    else if(now.direction == 2)
                        now.direction = 1;
                    else if(now.direction == 3)
                            now.direction = 4;
                    else if(now.direction == 4)
                            now.direction = 3;
                    x = now.x + dx[now.direction];
                    y = now.y + dy[now.direction];
                    if(!check(x, y) || map[x][y] == 2) {
                        Iterator<Integer> it = tempList.iterator();
                        while(it.hasNext()) {
                            int num = it.next();
                            chip[num].x = now.x;
                            chip[num].y = now.y;
                            list[now.x][now.y].add(num);
                        }
                        if(list[now.x][now.y].size() >= 4)
                            return true;
                    }
                    else if(map[x][y] == 0) {
                        Iterator<Integer> it = tempList.iterator();
                        while(it.hasNext()) {
                            int num = it.next();
                            chip[num].x = x;
                            chip[num].y = y;
                            list[x][y].add(num);
                        }
                        if(list[x][y].size() >= 4)
                            return true;
                    }
                    else if(map[x][y] == 1){
                            Collections.reverse(tempList);
                            Iterator<Integer> it = tempList.iterator();
                            while(it.hasNext()) {
                                int num = it.next();
                                chip[num].x = x;
                                chip[num].y = y;
                                list[x][y].add(num);
                            }
                            if(list[x][y].size() >= 4)
                                return true;
                    }
            }
        }
        return false;
    }
    
    public static boolean check(int x, int y) {
        return x >= 1 && y >= 1 && x <= n && y <= n;
    }
    
    static class Chip{
        int x, y, direction;
        
        Chip(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.direction = d;
        }
    }
}
