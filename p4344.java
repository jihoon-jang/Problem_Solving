import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p4344 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.parseInt(br.readLine());
		for(int l = 0; l < loop; l++)
		{
			String line = br.readLine();
			String[] s = line.split(" ");
			
			int number = Integer.parseInt(s[0]);
			int average = 0;
			for(int i = 1; i < number+1; i++)
			{
				average += Integer.parseInt(s[i]);
			}
			average /= number;
			int count = 0;
			for(int i = 1; i < number +1; i++)
				if(Integer.parseInt(s[i]) > average)
					count++;
			double answer = ((double)count/number*100);
			System.out.printf("%.3f",  answer);
			System.out.println("%");
		}
	}

}
