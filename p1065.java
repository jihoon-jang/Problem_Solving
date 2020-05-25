import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1065 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int number = Integer.parseInt(n);

		if(number < 100)
			System.out.println(number);
		else
		{
			int count = 99;
			for(int i =  100; i <= number; i++)
			{
				String s = String.valueOf(i);
				int a = 0;
				int b = 0;

				a = Integer.parseInt(s.substring(0, 1)) - Integer.parseInt(s.substring(1, 2));
				b = Integer.parseInt(s.substring(1, 2)) - Integer.parseInt(s.substring(2, 3));
				if(a == b)
				{
					count ++;
				}
			}
			System.out.println(count);
		}
	}

}
