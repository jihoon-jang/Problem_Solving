import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2577 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = 1;
		number *= Integer.parseInt(br.readLine());
		number *= Integer.parseInt(br.readLine());
		number *= Integer.parseInt(br.readLine());
		String s = String.valueOf(number);
		String[] a = s.split("");
		int[] n = new int[10];
		
		for(int i = 0; i < a.length; i++)
		{
			n[Integer.parseInt(a[i])]++;
		}
		for(int i = 0; i < 10; i++)
		{
			System.out.println(n[i]);
		}
	}

}
