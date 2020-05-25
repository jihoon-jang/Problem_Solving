import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10820 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do
		{
			int[] a = new int[4];
			String s = br.readLine();
			char[] c = s.toCharArray();
			for(int i = 0; i < c.length; i++)
			{
				if(c[i] == 32)
					a[3]++;
				else if(c[i]>=97 && c[i] <=122)
					a[0]++;
				else if(c[i]>=65 && c[i] <= 90)
					a[1]++;
				else
					a[2]++;
			}
			
			for(int i = 0 ; i< 4; i++)
				System.out.print(a[i] + " ");
			System.out.println();
		}while(br.ready());
	}

}
