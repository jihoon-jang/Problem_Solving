import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2884 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] sa = (s.split(" "));
		int[] a = {Integer.parseInt(sa[0]), Integer.parseInt(sa[1])};

		int h = a[0];
		int m = a[1];
		m-=45;
		if(m < 0)
		{
			h--;
			m+=60;
		}
		if(h<0)
		
			h+=24;
		
		System.out.println(h + " " + m);
		
	}

}
