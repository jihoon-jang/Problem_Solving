import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2174 {
    
    public static int a, b, map[][];
    public static Robot array[];
    //U,R,D,L(N,E,S,W)
    public static int dx[] = {-1,0,1,0};
    public static int dy[] = {0,1,0,-1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        a = Integer.parseInt(stz.nextToken());
        b = Integer.parseInt(stz.nextToken());
        map = new int[b+1][a+1];
        stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        array = new Robot[n+1];
        
        for(int i = 1; i <= n; i++){
            stz = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stz.nextToken());
            int y = Integer.parseInt(stz.nextToken());
            char c = stz.nextToken().charAt(0);
            int dir;
            if(c == 'N')
                dir = 0;
            else if(c == 'E')
                dir = 1;
            else if(c == 'S')
                dir = 2;
            else
                dir = 3;
            array[i] = new Robot(b-y+1, x, dir);
            map[b-y+1][x] = i;
        }
        
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(stz.nextToken());
            char c = stz.nextToken().charAt(0);
            int loop = Integer.parseInt(stz.nextToken());
            
            Robot robot = array[num];
            for(int l = 0; l < loop; l++) {
                if(c == 'R') {
                    robot.dir++;
                    if(robot.dir == 4)
                        robot.dir = 0;
                }
                else if(c == 'L'){
                    robot.dir--;
                    if(robot.dir == -1)
                        robot.dir = 3;
                }
                else {
                    int nx = robot.x + dx[robot.dir];
                    int ny = robot.y + dy[robot.dir];

                    if(!checkWall(nx, ny)) {
                        System.out.printf("Robot %d crashes into the wall", num);
                        return;
                    }

                    if(!checkCrash(nx, ny)){
                        System.out.printf("Robot %d crashes into robot %d", num, map[nx][ny]);
                        return;
                    }
                    map[robot.x][robot.y] = 0;
                    robot.x = nx;
                    robot.y = ny;
                    map[robot.x][robot.y] = num;
                }
            }
        }
        System.out.println("OK");
    }
    
    public static boolean checkWall(int x, int y) {
        return x >= 1 && y >= 1 && x <= b && y <= a;
    }
    
    public static boolean checkCrash(int x, int y) {
        return map[x][y] == 0;
    }
    
    public static void print() {
        for(int i = 1; i <= b; i++){
            for(int j = 1; j <= a; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }
    
    static class Robot {
        int x, y, dir;
        
        Robot(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.dir = d;
        }
    }
}
