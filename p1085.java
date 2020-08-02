import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1085 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] sa = str.split(" ");
		int x = Integer.parseInt(sa[0]);
		int y = Integer.parseInt(sa[1]);
		int w = Integer.parseInt(sa[2]);
		int h = Integer.parseInt(sa[3]);
		int ans = 0;
		
		ans = x;
		if(Math.abs((w-x)) < x)
			ans = Math.abs((w-x));
		if(Math.abs((y-h)) <= y)
		{
			if(Math.abs((y-h)) < ans)
				ans = Math.abs((y-h));
		}
		else
			if(ans > y)
			ans = y;
		System.out.println(ans);
	}

}