import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1476 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();
		String[] a = st.split(" ");
		int e = Integer.parseInt(a[0]);
		int s = Integer.parseInt(a[1]);
		int m = Integer.parseInt(a[2]);
		int year = 1;
		int[] arr = {1, 1, 1};
		
		while(true)
		{
			if(e== arr[0] && s==arr[1] && m == arr[2])
				break;
		
			arr[0]++; arr[1]++; arr[2]++;
			year++;
			if(arr[0] == 16)
				arr[0] = 1;
			if(arr[1] == 29)
				arr[1] = 1;
			if(arr[2] == 20)
				arr[2] = 1;
		}
		System.out.println(year);
	}

}
