import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class p3025 {
    
    static int r, c, R, C;
    static char map[][];
    //block[y] = x : 세로축 y에서 가로축 x에 존재하는 장애물
    static TreeSet<Integer> block[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        //가로의 수
        r = Integer.parseInt(stz.nextToken());
        //세로의 수
        c = Integer.parseInt(stz.nextToken());
        //패딩 값을 포함한 범위
        R = r + 1;
        C = c + 2;
        map = new char[R][C];
        block = new TreeSet[C];
        //경계값
        for(int i = 0; i < R; i++){
            map[i][0] = 'X';
            map[i][c+1] = 'X';
        }
        for(int i = 0; i < C; i++) {
            map[r][i] = 'X';
            block[i] = new TreeSet<>();
        }
        
        //입력
        for(int i = 0; i < r; i++) {
            String line = br.readLine();
            for(int j = 1; j <= c; j++)
                map[i][j] = line.charAt(j-1);
        }
        //block에 열마다 장애물 위치 추가
        checkHeight();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int stone = Integer.parseInt(br.readLine());
            game(stone);
        }
        //결과 출력
        print();
    }
    
    //map을 순회하며 장애물의 위치를 block에 추가
    public static void checkHeight() {
        for(int i = 1; i <= c; i++){
            for(int j = 0; j <= r; j++){
                if(map[j][i] == 'X')
                    block[i].add(j);
            }
        }
    }
    
    //돌 놓기 x = y번째 열 0보다 큰 첫 장애물 -1, y = y
    public static void game(int stone) {
        int y = stone;
        drop(block[y].higher(0)-1, y);
    }
    
    public static void drop(int x, int y) {
        //밑이 'X'면 그 위치에 돌을 놓고 block에 추가
        if(map[x+1][y] == 'X') {
            map[x][y] = 'O';
            block[y].add(x);
        }
        //밑이 'O' -> 돌이라면
        else if(map[x+1][y] == 'O') {
            //왼쪽으로 이동 가능한가?
            if(checkLeft(x, y))
                //y좌표 1빼주고 y-1열의 현재 위치보다 큰 장애물 -1로 이동.
                //ex) (6,2)가 장애물일 때 (3,3) -> (5,2) 로 이동
                drop(block[y-1].higher(x)-1, y-1);
            //좌측 이동 불가 시 
            else {
                //우측 검사
                if(checkRight(x, y))
                    //우측으로 이동(좌측과 같지만 y좌표가 +1)
                    drop(block[y+1].higher(x)-1, y+1);
                else {
                    //좌측, 우측 둘 다 불가시 돌 놓고 block에 추가
                    map[x][y] = 'O';
                    block[y].add(x);
                }
            }
        }
    }
    
    //좌측 검사
    public static boolean checkLeft(int x, int y) {
        //왼쪽, 왼쪽-아래 검사
        if(map[x][y-1] == '.' && map[x+1][y-1] == '.')
            return true;
        else
            return false;
    }
    
    //우측 검사
    public static boolean checkRight(int x, int y) {
        //우측, 우측-아래 검사
        if(map[x][y+1] == '.' && map[x+1][y+1] == '.')
            return true;
        else
            return false;
    }
    
    public static void print() {
        for(int i = 0; i < r; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j <= c; j++)
                sb.append(map[i][j]);
            System.out.println(sb.toString());
        }
    }
}
