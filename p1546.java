import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1546 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.parseInt(br.readLine());
		String line = br.readLine();
		String[] s = line.split(" ");
		
		int max = 0;
		int sum = 0;
		for(int i = 0; i < s.length; i++)
		{
			sum += Integer.parseInt(s[i]);
			if(Integer.parseInt(s[i]) > max)
				max = Integer.parseInt(s[i]);
		}
		System.out.println(((double)sum / (double)max) *100/s.length);
	}

}
