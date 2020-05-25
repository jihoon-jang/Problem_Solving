import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10992 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int count = 1;
		for(int l = n; l > 0; l--)
		{
			if(l == n)
			{
				for(int i = 1; i < n; i++)
					System.out.print(" ");
				System.out.println("*");
			
			}

			else if(l != n && l != 1)
			{
				for(int i = 1; i < l; i++)
					System.out.print(" ");
				System.out.print('*');
				for(int i = 0; i < count; i++)
					System.out.print(" ");
				System.out.println('*');
			count += 2;
			}
			
			else
			{
				for(int i = 0; i < (n-1)*2+1; i++)
					System.out.print('*');
			}
		}
	}

}
