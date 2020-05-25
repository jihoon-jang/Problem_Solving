import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] a = str.split("");
		String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		int[] n = new int[26];
		Arrays.fill(n, -1);

		for(int i = 0; i < a.length; i++)
		{
			int index = -1;
			for(int j = 0; j < alphabet.length; j++)
			{
				if(a[i].equals(alphabet[j]))
				{
					index = j;
					break;
				}
			}
			
			if(n[index] == -1)
				n[index] = i;
		}
		
		for(int i = 0; i < n.length; i ++)
			System.out.print(n[i] + " ");
	}

}
