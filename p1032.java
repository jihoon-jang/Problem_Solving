import java.io.*;

public class p1032 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String array[] = new String[n];
		
		for(int i = 0; i < n; i++)
			array[i] = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		l:for(int i = 0; i < array[0].length(); i++) {
			for(int j = 0; j < n-1; j++) {
				if(array[j].charAt(i) != array[j+1].charAt(i)) {
					sb.append('?');
					continue l;
				}
			}
			sb.append(array[0].charAt(i));
		}
		
		System.out.println(sb.toString());
	}

}
