import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2675 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int loop = Integer.parseInt(br.readLine());
		for(int l = 0; l < loop; l++)
		{
			String str = br.readLine();
			String[] arr = str.split(" ");
			
			int loo = Integer.parseInt(arr[0]);
			for(int i = 0; i < arr[1].length(); i++)
			{
				for(int j = 0; j < loo; j++)
				{
					System.out.print(arr[1].substring(i, i+1));
				}
			}
			System.out.println();
		}
	}

}
