import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10830 {
    
    static int n, matrix[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        long b = Long.parseLong(stz.nextToken());
        matrix = new int[n][n];
        for(int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                matrix[i][j] = Integer.parseInt(stz.nextToken());
        }
        int answer[][] = divide(b);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                sb.append(answer[i][j]%1000 + " ");
            sb.append("\n");
        }
    
        System.out.println(sb.toString());
    }
    
    public static int[][] divide(long index) {
        if(index == 1) {
            return matrix;
        }
        
        if(index % 2 == 0) {
            int temp[][] = divide(index/2);
            return cal(temp, temp);
        }
        else {
            int temp[][] = divide((index-1)/2);
            return cal(matrix, cal(temp, temp));
        }
    }
    
    public static int[][] cal(int mat1[][], int mat2[][]) {
        int result[][] = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int value = 0;
                for(int k = 0; k < n; k++) {
                    value += (mat1[i][k] * mat2[k][j]) % 1000;
                }
                result[i][j] = value % 1000;
            }
        }
        
        return result;
    }
}
