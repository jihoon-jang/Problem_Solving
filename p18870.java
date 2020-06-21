import java.io.*;
import java.util.*;

public class p18870 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String s[] = br.readLine().split(" ");
		int array[] = new int[n];
		int array2[] = new int[n];
		HashMap<Integer, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(s[i]);
			array2[i] = array[i];
		}
		
		Arrays.sort(array2);
		int value = 0;
		map.put(array2[0], value++);
		for(int i = 1; i < n; i++) {
			if(array2[i] != array2[i-1])
				map.put(array2[i], value++);
		}
		
		for(int i = 0; i < n; i++) 
			sb.append(map.get(array[i])+" ");
		
		bw.write(sb.toString());
		bw.flush();
	}

}
