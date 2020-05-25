import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2312 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.parseInt(br.readLine());

		for(int l = 0; l < loop; l++)
		{
			int number = Integer.parseInt(br.readLine());
			int[] array = new int[number+1];
			for(int i = 2; i <= number; i++)
			{
				if(number%i == 0)
				{
					number /= i;
					array[i]++;
					i=1;
				}
			}
			for(int i = 0; i < array.length; i++)
			{
				if(array[i] != 0)
					System.out.println(i + " " + array[i]);
			}
		}
	}

}
