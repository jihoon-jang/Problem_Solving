import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1110 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();
		String answer = number;
		int count = 0;

		while(true)
		{
			int x = 0;
			int y = 0;

			if(number.length() > 1)
			{
				x = Integer.parseInt(number.substring(1, 2));
				y = Integer.parseInt(number.substring(0, 1));
			}
			else
				x = Integer.parseInt(number);

			int newnum = x*10+(x+y)%10;
			number = ""+newnum;
			count++;
			if(newnum == Integer.parseInt(answer))
				break;
		}
		System.out.println(count);
	}
	//55 50 05 55
}
