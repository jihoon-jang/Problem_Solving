import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		char[][] array = new char[5][15]; 
		for(int i = 0; i < 5; i++)
		{
			String s = br.readLine();
			char[] c = s.toCharArray();
			for(int j = 0; j < c.length; j++)
				array[i][j] = c[j];
		}
		
		for(int j = 0; j < 15; j++)
		{
			for(int i = 0; i < 5; i++)
				if(array[i][j] != 0)
				System.out.print(array[i][j]);
		}
	}

}
