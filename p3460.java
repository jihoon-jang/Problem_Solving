import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3460 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.parseInt(br.readLine());

		for(int l = 0; l < loop; l++)
		{
			int num = Integer.parseInt(br.readLine());
			int index = 0;
			do
			{
				if(num % 2 == 1)
				{
					num /= 2;
					System.out.print(index + " ");
				}
				else
					num/=2;

				index ++;
			}while(num>1);
			if(num == 1)
				System.out.println(index);
		}
	}

}
