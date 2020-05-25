import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class p10817 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = new String[3];
		String line = br.readLine();
		s = (line.split(" "));
		int[] array = new int[3];
		for(int i = 0; i < 3; i++)
			array[i] = Integer.parseInt(s[i]);
		Arrays.sort(array);
		System.out.println(array[1]);
		bw.write(array[1]);
		bw.flush();
	}

}
