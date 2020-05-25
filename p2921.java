import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2921 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int count = 0;
		
		for(int i = 1 ; i <= num; i++)
		{
			count += i*(i+1);
			for(int j = 0; j <= i; j++)
				count += j;
		}
		System.out.println(count);
	}

}
