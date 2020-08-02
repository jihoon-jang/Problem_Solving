import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1152 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] array = new String[s.length()];
		array = s.split("");
		int count = 0;
		
		if(!array[0].equals(" "))
			count++;
		for(int i = 0; i < array.length-1; i++)
		{
			if(array[i].equals(" ") && !array[i+1].equals(" "))
				count++;
		}
		System.out.println(count);
	}

}
