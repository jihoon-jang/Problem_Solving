import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String[] arr = str.split("");
		int number = arr.length;
		for(int i = 1; i < arr.length; i++)
		{
			if(arr[i].equals("="))
			{
				if(i>1)
				{
					if(arr[i-2].equals("d") && arr[i-1].equals("z"))
						number -=2;
					else
						number--;
				}
				else
				number--;
			}
			else if(arr[i].equals("-"))
			{
				number--;
			}
			else if(arr[i].equals("j"))
			{
				if(arr[i-1].equals("l") || arr[i-1].equals("n"))
					number--;
			}
		}

		System.out.println(number);
	}

}
