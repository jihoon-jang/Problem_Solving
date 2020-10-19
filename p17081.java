import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p17081 {
    
    static int n, m, turn;
    static int map[][];
    static Monster monster[];
    static Item item[];
    static boolean finish = false;
    static String killer = "NOBODY";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        turn = 0;
        map = new int[n][m];
        Player player = new Player();
        //보스 좌표
        int bx = 0, by = 0;
        //몬스터 수
        int monsterCount = 0;
        int itemCount = 0;
        //. = 0, # = 1, B = 2; ^ = 3;
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                char c = input.charAt(j);
                switch(c) {
                    case '.' : map[i][j] = 0; break;
                    case '#' : map[i][j] = 1; break;
                    case 'B' : map[i][j] = 2; itemCount++; break;
                    case '^' : map[i][j] = 3; break;
                    case '@' : map[i][j] = 0; player = new Player(i, j); break;
                    case 'M' : bx = i; by = j; monsterCount++; break;
                    case '&' : monsterCount++; break;
                }
            }
        }
        String command = br.readLine();
        monster = new Monster[monsterCount];
        for(int i = 0; i < monsterCount; i++) {
            String info[] = br.readLine().split(" ");
            int x = Integer.parseInt(info[0])-1;
            int y = Integer.parseInt(info[1])-1;
            String n = info[2];
            int w = Integer.parseInt(info[3]);
            int a = Integer.parseInt(info[4]);
            int h = Integer.parseInt(info[5]);
            int e = Integer.parseInt(info[6]);
            boolean boss;
            if(x == bx && y == by)
                boss = true;
            else
                boss = false;
            monster[i] = new Monster(x, y, n, w, a, h, e, boss);
            map[x][y] = 10+i;
        }
        
        item = new Item[itemCount];
        for(int i = 0; i < itemCount; i++) {
            String info[] = br.readLine().split(" ");
            int x, y;
            if(info[2].equals("O")) {
                x = Integer.parseInt(info[0])-1;
                y = Integer.parseInt(info[1])-1;
                char c = info[2].charAt(0);
                String acc = info[3];
                item[i] = new Item(x, y, c, acc);
            }
            else {
                x = Integer.parseInt(info[0])-1;
                y = Integer.parseInt(info[1])-1;
                char c = info[2].charAt(0);
                int v = Integer.parseInt(info[3]);
                item[i] = new Item(x, y, c, v);
            }
            map[x][y] = -1*(i+1);
        }
        
        for(int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            turn++;
            player.move(c);
            if(player.die()) {
                player.print();
                System.out.println("YOU HAVE BEEN KILLED BY " + killer + "..");
                return;
            }
            else if(finish) {
                player.print();
                System.out.println("YOU WIN!");
                return;
            }
        }
        
        player.print();
        System.out.println("Press any key to continue.");
    }
    
    static class Player {
        int x, y, startX, startY;
        int hp, nowHp, wStat, aStat, exp, level;
        int w, a;
        LinkedList<String> accList;
        
        Player(){}
        
        Player(int x, int y) {
            this.x = x;
            this.y = y;
            startX = x;
            startY = y;
            hp = 20;
            nowHp = 20;
            wStat = 2;
            aStat = 2;
            level = 1;
            exp = 0;
            accList = new LinkedList<>();
            w = 0;
            a = 0;
        }
        
        void print() {
            if(nowHp > 0)
                map[x][y] = 4;
            
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++)
                    //. = 0, # = 1, B = 2; ^ = 3;
                    if(map[i][j] == 0)
                        System.out.print('.');
                    else if(map[i][j] == 1)
                        System.out.print('#');
                    else if(map[i][j] == 2)
                            System.out.print('B');
                        else if(map[i][j] == 3)
                                System.out.print('^');
                            else if(map[i][j] >= 10) {
                                    if(monster[map[i][j]-10].boss)
                                        System.out.print('M');
                                    else
                                        System.out.print('&');
                                }
                                else if(map[i][j] < 0)
                                        System.out.print('B');
                                    else if(map[i][j] == 4)
                                            System.out.print('@');
                System.out.println();
            }
            System.out.printf("Passed Turns : %d\n", turn);
            System.out.printf("LV : %d\n", level);
            System.out.printf("HP : %d/%d\n", nowHp < 0 ? 0 : nowHp, hp);
            System.out.printf("ATT : %d+%d\n", wStat-w, w);
            System.out.printf("DEF : %d+%d\n", aStat-a, a);
            System.out.printf("EXP : %d/%d\n", exp, level*5);
        }
        
        void change(char c, int value) {
            if(c == 'W') {
                wStat -= w;
                w = value;
                wStat += w;
            }
            else {
                aStat -= a;
                a = value;
                aStat += a;
            }
        }
        
        //장신구
        void change(String acc) {
            if(accList.contains(acc) || accList.size() >= 4)
                return;
            accList.add(acc);
        }
        
        boolean die() {
            if(nowHp <= 0) {
                if(accList.contains("RE")) {
                    nowHp = hp;
                    x = startX;
                    y = startY;
                    accList.remove("RE");
                    return false;
                }
                if(killer.equals("NOBODY"))
                    killer = "SPIKE TRAP";
                return true;
            }
            else
                return false;
        }
        
        void move(char c) {
            int dx[] = {-1,1,0,0};
            int dy[] = {0,0,-1,1};
            
            int nx, ny;
            switch(c) {
                case 'U' : nx = x + dx[0]; ny = y + dy[0]; break;
                case 'D' : nx = x + dx[1]; ny = y + dy[1]; break;
                case 'L' : nx = x + dx[2]; ny = y + dy[2]; break;
                default:  nx = x + dx[3]; ny = y + dy[3]; break;
            }
            
            int temp;
            if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] != 1) {
                temp = x;
                x = nx;
                nx = temp;
                temp = y;
                y = ny;
                ny = temp;
            }
            
            if(map[x][y] == 3){
                trap();
            }
            else if(map[x][y] >= 10) {
                Monster mon = monster[map[x][y]-10];
                if(!fight(mon.name, mon.w, mon.a, mon.h, mon.e, mon.boss)) {
                    x = nx;
                    y = ny;
                }
            }
            else if(map[x][y] < 0){
                    Item it = item[map[x][y]*-1-1];
                    if(it.type == 'O') {
                        change(it.acc);
                    }
                    else
                        change(it.type, it.value);
                    map[x][y] = 0;
                }
        }
        
        boolean fight(String name, int w, int a, int h, int e, boolean boss) {
            boolean guard = false;
            boolean buff = false;
            if(accList.contains("HU") && boss) {
                nowHp = hp;
                guard = true;
            }
            if(accList.contains("CO"))
                buff = true;
            
            while(h > 0 && nowHp > 0) {
                if(buff && accList.contains("DX"))
                    h -= Math.max(1, wStat*3 - a);
                else if(buff)
                    h -= Math.max(1, wStat*2 - a);
                else
                    h -= Math.max(1, wStat - a);
                buff = false;
                if(h <= 0)
                    break;
                if(!guard)
                    nowHp -= Math.max(1, w - aStat);
                else
                    guard = false;
            }
            //몬스터 죽음
            if(h <= 0) {
                map[x][y] = 0;
                if(accList.contains("HR")) {
                    nowHp += 3;
                    if(nowHp > hp)
                        nowHp = hp;
                }
                if(accList.contains("EX"))
                    exp += 1.2*e;
                else
                    exp += e;
                levelUp();
                if(boss)
                    finish = true;
            }
            //캐릭터 죽음
            if(nowHp <= 0) {
                if(accList.contains("RE")) {
                    nowHp = hp;
                    x = startX;
                    y = startY;
                    accList.remove("RE");
                    return true;
                }
                killer = name;
                return false;
            }
            return true;
        }
        
        void levelUp() {
            if(exp >= level*5) {
                level++;
                exp = 0;
                hp += 5;
                wStat += 2;
                aStat += 2;
                nowHp = hp;
            }
        }
        
        void trap() {
            if(accList.contains("DX"))
                nowHp -= 1;
            else
                nowHp -= 5;
        }
    }
    
    static class Monster{
        int x, y, w, a, h, e;
        boolean boss;
        String name;
        
        Monster(int x, int y, String n, int w, int a, int h, int e, boolean boss) {
            this.x = x;
            this.y = y;
            name = n;
            this.w = w;
            this.a = a;
            this.h = h;
            this.e = e;
            this.boss = boss;
        }
    }
    
    static class Item {
        int x, y, value;
        char type;
        String acc;
        
        //O 입력
        Item(int x, int y, char t, String a) {
            this.x = x;
            this.y = y;
            this.type = t;
            acc = a;
        }
        
        //W, A 입력
        Item(int x, int y, char t, int value) {
            this.x = x;
            this.y = y;
            this.type = t;
            this.value = value;
        }
    }
}
