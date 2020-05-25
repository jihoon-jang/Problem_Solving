import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3046 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] sa = s.split(" ");
		System.out.println(Integer.parseInt(sa[1])*2 - Integer.parseInt(sa[0]));
	}

}
