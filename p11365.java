import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p11365 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str=new String();
		while(true)
		{
			str = br.readLine();
			if(str.equals("END"))
				break;
			String[] s = str.split("");
			for(int i = s.length-1; i >= 0; i--)
				System.out.print(s[i]);
			System.out.println();
		}
	}

}
