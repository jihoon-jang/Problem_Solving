import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p10871 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		String[] s = line.split(" ");
		int number = Integer.parseInt(s[1]);
		s = new String[Integer.parseInt(s[0])];
		line = br.readLine();
		s = line.split(" ");
		
		for(int i = 0; i <  s.length; i++)
		{
			if(number > Integer.parseInt(s[i]))
				bw.write(s[i] + " ");
			
		}
		bw.flush();
	}

}
