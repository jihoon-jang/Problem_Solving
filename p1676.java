import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1676 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int num5 = 0;
		for(int i = 1; i <= n; i++)
		{                  
			int number = i;
			if(number % 5 == 0)
			{
				do
				{
					number /= 5;
					num5++;
				}while(number % 5 == 0);
			}
		}
		System.out.println(num5);

	}

}
