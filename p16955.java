import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p16955 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char map[][] = new char[10][10];
        for(int i = 0; i < 10; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();
        }
        
         for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(map[i][j] == 'X') {
                    a : for(int l = 0; l < 4; l++) {
                        boolean poss = true;
                        int x = 0;
                        for(int k = 1; k < 5; k++) {
                            switch(l) {
                                case 0 :
                                    if(check(i+k, j)) {
                                        if(map[i+k][j] == 'O') {
                                            poss = false;
                                            continue a;
                                        }
                                        else if(map[i+k][j] == 'X')
                                            x++;
                                    }
                                    else {
                                        poss = false;
                                        continue a;
                                    }
                                    break;
                                case 1:
                                    if(check(i, j+k)) {
                                        if(map[i][j+k] == 'O') {
                                            poss = false;
                                            continue a;
                                        }
                                        else if(map[i][j+k] == 'X') {
                                            x++;
                                        }
                                    }
                                    else {
                                        poss = false;
                                        continue a;
                                    }
                                    break;
                                case 2:
                                    if(check(i+k, j+k)) {
                                        if(map[i+k][j+k] == 'O') {
                                            poss = false;
                                            continue a;
                                        }
                                        else if(map[i+k][j+k] == 'X') {
                                            x++;
                                        }
                                    }
                                    else {
                                        poss = false;
                                        continue a;
                                    }
                                    break;
                                case 3:
                                    if(check(i+k, j-k)) {
                                        if(map[i+k][j-k] == 'O') {
                                            poss = false;
                                            continue a;
                                        }
                                        else if(map[i+k][j-k] == 'X') {
                                            x++;
                                        }
                                    }
                                    else {
                                        poss = false;
                                        continue a;
                                    }
                                    break;
                            }
                        }
                        if(poss && x == 3) {
                            System.out.println(1);
                            return;
                        }
                    }
                }
            }
        }
    
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(map[i][j] == '.') {
                    map[i][j] = 'X';
                    if(map[i][j] == 'X') {
                        a:
                        for(int l = 0; l < 4; l++) {
                            boolean poss = true;
                            int x = 0;
                            for(int k = 1; k < 5; k++) {
                                switch(l) {
                                    case 0:
                                        if(check(i + k, j)) {
                                            if(map[i + k][j] == 'O') {
                                                poss = false;
                                                continue a;
                                            }
                                            else
                                                if(map[i + k][j] == 'X')
                                                    x++;
                                        }
                                        else {
                                            poss = false;
                                            continue a;
                                        }
                                        break;
                                    case 1:
                                        if(check(i, j + k)) {
                                            if(map[i][j + k] == 'O') {
                                                poss = false;
                                                continue a;
                                            }
                                            else
                                                if(map[i][j + k] == 'X') {
                                                    x++;
                                                }
                                        }
                                        else {
                                            poss = false;
                                            continue a;
                                        }
                                        break;
                                    case 2:
                                        if(check(i + k, j + k)) {
                                            if(map[i + k][j + k] == 'O') {
                                                poss = false;
                                                continue a;
                                            }
                                            else
                                                if(map[i + k][j + k] == 'X') {
                                                    x++;
                                                }
                                        }
                                        else {
                                            poss = false;
                                            continue a;
                                        }
                                        break;
                                    case 3:
                                        if(check(i + k, j - k)) {
                                            if(map[i + k][j - k] == 'O') {
                                                poss = false;
                                                continue a;
                                            }
                                            else
                                                if(map[i + k][j - k] == 'X') {
                                                    x++;
                                                }
                                        }
                                        else {
                                            poss = false;
                                            continue a;
                                        }
                                        break;
                                }
                            }
                            if(poss && x == 4) {
                                System.out.println(1);
                                return;
                            }
                        }
                    }
                    map[i][j] = '.';
                }
            }
        }
        
        System.out.println(0);
    }
    
    public static boolean check(int x, int y) {
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }
}
