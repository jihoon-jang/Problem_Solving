import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p17825 {
    
    static int board[][], map[][], answer = 0; // board = 점수, map = 위치
    static Pin pin[] = new Pin[5];
    static String input[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().split(" ");
        board = new int[][] {
                {0,2,4,6,8,-1,12,14,16,18,-1,22,24,26,28,-1,32,34,36,38,40,-2},
                {10,13,16,19,25,30,35,40,-2},
                {20,22,24,25,30,35,40,-2},
                {30,28,27,26,25,30,35,40,-2},
                {0}
        };
        map = new int[board.length][];
        for(int i = 0; i < board.length; i++)
            map[i] = new int[board[i].length];
        for(int i = 1; i <= 4; i++)
            pin[i] = new Pin(0, 0);
        map[0][5] = -1;
        map[0][10] = -2;
        map[0][15] = -3;
        map[0][21] = -4;
        map[1][8] = -4;
        map[2][7] = -4;
        map[3][8] = -4;
        
        move(0, 0);
        System.out.println(answer);
    }
    
    public static void move(int index, int score) {
        if(index == 10){
            answer = Math.max(answer, score);
            return;
        }
        int dice = Integer.parseInt(input[index]);
        Pin copy[] = new Pin[5];
        for(int i = 1; i <= 4; i++){
            copy[i] = new Pin(pin[i].x, pin[i].y);
            copy[i].finish = pin[i].finish;
        }
        int temp[][] = new int[map.length][];
        for(int i = 0; i < map.length; i++)
            temp[i] = map[i].clone();
        
        l:for(int i = 1; i <= 4; i++) {
            Pin now = pin[i];
            if(!now.finish) {
                int ny = now.y + dice;
                //종료
                if(ny >= board[now.x].length-1) {
                    now.finish = true;
                    map[now.x][now.y] = 0;
                    move(index+1, score);
                }
                //빈 칸 이동
                else if(map[now.x][ny] == 0){
                    if(board[now.x][ny] == 40) {
                        for(int j = 0; j < map.length-1; j++) {
                            if(map[j][map[j].length - 2] != 0) {
                                continue l;
                            }
                        }
                    }
                    if(now.x != 0 && board[now.x].length - ny <= 5) {
                        int diff = board[now.x].length - ny;
                        for(int j = 1; j < map.length-1; j++) {
                            if(map[j][board[j].length - diff] != 0) {
                                continue l;
                            }
                        }
                    }
                    map[now.x][now.y] = 0;
                    now.y = ny;
                    map[now.x][now.y] = i;
                    move(index+1, score + board[now.x][now.y]);
                }
                //파란 화살표
                else if(map[now.x][ny] < 0) {
                        if(map[map[now.x][ny]*-1][0] != 0)
                            continue;
                        map[now.x][now.y] = 0;
                        now.x = map[now.x][ny] * -1;
                        now.y = 0;
                        map[now.x][now.y] = i;
                        move(index+1, score + board[now.x][now.y]);
                    }
                for(int j = 1; j <= 4; j++){
                    pin[j] = new Pin(copy[j].x, copy[j].y);
                    pin[j].finish = copy[j].finish;
                }
                for(int j = 0; j < map.length; j++)
                    map[j] = temp[j].clone();
            }
        }
    }
    
    static class Pin {
        int x, y;
        boolean finish;
        
        Pin(int x, int y) {
            this.x = x;
            this.y = y;
            finish = false;
        }
    }
}
