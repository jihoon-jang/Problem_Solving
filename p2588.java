import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2588 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num1 = br.readLine();
		String num2 = br.readLine();
		String[] s = num2.split("" );
		for(int i = s.length-1; i >=0; i--)
			System.out.println(Integer.parseInt(num1)*Integer.parseInt(s[i]));
		System.out.println(Integer.parseInt(num1)*Integer.parseInt(num2));
	}

}
