import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p14490 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] sa = (s.split(":"));
		int[] a = {Integer.parseInt(sa[0]), Integer.parseInt(sa[1])};
		
		for(int i = 2; i <= Math.min(a[0], a[1]);)
		{
			if(a[0]%i ==0 && a[1] % i == 0)
			{
				a[0] /= i; a[1] /= i;
				i = 2;
			}
			else 
				i++;
		}
		System.out.println(a[0]+ ":"+a[1]);
	}

}
