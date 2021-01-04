import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2599 {
    
    static int student[][], answer[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int n = Integer.parseInt(br.readLine());
        student = new int[3][2];
        answer = new int[3][2];
        
        for(int i = 0; i < 3; i++) {
            stz = new StringTokenizer(br.readLine());
            student[i][0] = Integer.parseInt(stz.nextToken());
            student[i][1] = Integer.parseInt(stz.nextToken());
        }
        
        boolean finish = false;
        for(int i = 0; i <= student[0][0]; i++) {
            answer[0][0] = i;
            answer[0][1] = student[0][0] - i;
            answer[1][1] = student[2][1] - answer[0][1];
            answer[1][0] = student[1][0] - answer[1][1];
            answer[2][0] = student[0][1] - answer[1][0];
            answer[2][1] = student[2][0] - answer[2][0];
            
            if(answer[0][0] >= 0 && answer[0][1] >= 0 && answer[1][0] >= 0 && answer[1][1] >= 0 && answer[2][0] >= 0 && answer[2][1] >= 0){
                System.out.println(1);
                System.out.println(answer[0][0]+" "+answer[0][1]);
                System.out.println(answer[1][0]+" "+answer[1][1]);
                System.out.println(answer[2][0]+" "+answer[2][1]);
                finish = true;
                break;
            }
        }
        
        if(!finish)
            System.out.println(0);
    }
}
