import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2902 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		char[] c = str.toCharArray();
		for(int i = 0; i < c.length; i++)
		{
			if(c[i]>=65 && c[i]<=90)
				System.out.print(c[i]);
		}
	}

}
