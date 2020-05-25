import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p15552 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int loop = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < loop; i ++)
		{
			String[] s = br.readLine().split(" ");
			int answer = Integer.parseInt(s[0]) + Integer.parseInt(s[1]);
			bw.write(answer+"\n");
		}
		bw.flush();
	}

}
