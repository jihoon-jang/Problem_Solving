import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10950 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; ; i++)
		{
			String s = br.readLine();
			String[] sarr = s.split(" ");
			int a = Integer.parseInt(sarr[0]);
			int b = Integer.parseInt(sarr[1]);
			if(a==0&&b==0)
				break;
			System.out.println(a+b);
		}

	}

}
