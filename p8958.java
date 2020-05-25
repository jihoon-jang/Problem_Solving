import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p8958 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.parseInt(br.readLine());

		for(int l = 0; l < loop; l++)
		{
			String s = br.readLine();
			String[] a = s.split("");
			int[] score = new int[a.length];
			boolean start = true;
			int sum = 0;

			for(int i = 0; i < a.length; i++)
			{
				if(a[i].equals("O") && start)
				{
					score[i] = 1;
					start = false;
					continue;
				}

				if(a[i].equals("O"))
					score[i] = score[i-1]+1;
				else
					start = true;
			}
			for(int i = 0; i < score.length; i++)
			//	System.out.print(score[i]);
			sum+=score[i];
			System.out.println(sum);
		}

	}

}
