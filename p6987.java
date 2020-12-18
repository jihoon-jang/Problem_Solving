import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p6987 {
    
    static int match[][];
    static boolean poss;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        StringBuilder sb = new StringBuilder();
        match = new int[15][2];
        int index = 0;
        for(int i = 0; i < 5; i++) {
            for(int j = i + 1; j < 6; j++) {
                match[index][0] = i;
                match[index][1] = j;
                index++;
            }
        }
        
        l : for(int i = 0; i < 4; i++) {
            stz = new StringTokenizer(br.readLine());
            int score[][] = new int[6][3];
            
            for(int j = 0; j < 6; j++) {
                int countryW = Integer.parseInt(stz.nextToken());
                int countryD = Integer.parseInt(stz.nextToken());
                int countryL = Integer.parseInt(stz.nextToken());
                
                if(countryD + countryL + countryW != 5) {
                    sb.append(0 + " ");
                    continue l;
                }
                
                score[j][0] = countryW;
                score[j][1] = countryD;
                score[j][2] = countryL;
            }
            poss = false;
            dfs(score, 0);
            if(poss)
                sb.append(1 + " ");
            else
                sb.append(0 + " ");
        }
        System.out.println(sb.toString());
    }
    
    public static void dfs(int score[][], int index) {
        if(poss)
            return;
        
        if(index == 15) {
            poss = true;
            return;
        }
        
        int teamA = match[index][0];
        int teamB = match[index][1];
    
        if(score[teamA][0] > 0 && score[teamB][2] > 0) {
            score[teamA][0]--;
            score[teamB][2]--;
            dfs(score, index+1);
            score[teamA][0]++;
            score[teamB][2]++;
        }
        if(score[teamA][1] > 0 && score[teamB][1] > 0) {
            score[teamA][1]--;
            score[teamB][1]--;
            dfs(score, index+1);
            score[teamA][1]++;
            score[teamB][1]++;
        }
        if(score[teamA][2] > 0 && score[teamB][0] > 0) {
            score[teamA][2]--;
            score[teamB][0]--;
            dfs(score, index+1);
            score[teamA][2]++;
            score[teamB][0]++;
        }
    }
}