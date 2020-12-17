import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class p18119 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int array[] = new int[n];
        
        for(int i = 0; i < n; i++) {
            int num = 0;
            String word = br.readLine();
            
            for(int j = 'a'; j <= 'z'; j++) {
                if(word.contains("" + (char)j)) {
                    int temp = 1 << j - 'a';
                    num |= temp;
                }
            }
            array[i] = num;
        }
        
        int alphabet = (1 << 26) - 1;
        
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(stz.nextToken());
            char c = stz.nextToken().charAt(0);
            
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                continue;
            
            int cal = 1 << c - 'a';
            if(command == 1) {
                if((alphabet & cal) == cal)
                    alphabet -= cal;
            }
            else {
                alphabet |= cal;
            }
            
            int count = 0;
            for(int number : array) {
                if((number & alphabet) == number)
                    count++;
            }
            bw.write(count + "\n");
        }
        bw.flush();
    }
}
