import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p1475 {
	static int ans = 1;
	static int[] array = new int[9];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String[] sa = s.split("");

		Arrays.fill(array, 1);
		array[6] = 2;

		for(int i = 0; i < sa.length; i++)
		{
			if(sa[i].equals("9"))
				sa[i] = "6";
		}

		for(int i = 0; i < sa.length; i++)
		{
			if(array[Integer.parseInt(sa[i])] != 0)
				array[Integer.parseInt(sa[i])] --;
			else
			{
				plus();
				array[Integer.parseInt(sa[i])] --;
			}
		}

		System.out.println(ans);
	}

	public static void plus()
	{
		ans ++;
		for(int i = 0; i < array.length; i++)
			array[i] ++;
		array[6] ++;
	}

}
