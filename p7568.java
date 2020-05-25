import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p7568 {

	public static void main(String[] args) throws NumberFormatException, IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int person[][] = new int[3][n];
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			String sa[] = s.split(" ");
			person[0][i] = Integer.parseInt(sa[0]);
			person[1][i] = Integer.parseInt(sa[1]);
		}
		
		for(int i = 0; i < n; i++) {
			int count = 0;
			for(int j = 0; j < n; j++) {
				if((person[0][i] < person[0][j] )&&(person[1][i] < person[1][j]))
					count++;
			}
			person[2][i] = count+1;
		}
			
		for(int i = 0; i < n; i++)
			System.out.print(person[2][i] + " ");
	}

}