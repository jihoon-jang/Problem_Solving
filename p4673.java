import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p4673 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[] number = new boolean[10001];


		for(int loop = 1; loop < 10001; loop++)
		{
			int temp = 0;
			String n = String.valueOf(loop);

			for(int i = 0; i < n.length(); i++)
				temp +=Integer.parseInt(n.substring(i, i+1)); 
			temp += loop;
			if(temp <= 10000)
			number[temp] = true;
		}
		
		for(int i = 1; i < 10001; i++)
		{
			if(!number[i])
				System.out.println(i);
		}
	}

}
