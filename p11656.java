import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p11656 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String array[] = new String[s.length()];
		
		for(int i = 0; i < s.length(); i++) 
			array[i] = s.substring(i);
		
		Arrays.sort(array);
		
		for(String str : array)
			System.out.println(str);
	}

}
