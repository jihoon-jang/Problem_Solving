import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2845 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] sa = s.split(" ");
		int ans  = Integer.parseInt(sa[0])*Integer.parseInt(sa[1]);
		s = br.readLine();
		sa = s.split(" ");
		for(int i  = 0; i < sa.length; i ++)
		{
			System.out.print(Integer.parseInt(sa[i]) - ans + " ");
		}
	}

}
