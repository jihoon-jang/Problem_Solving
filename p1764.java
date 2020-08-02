import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class p1764 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String t[] = br.readLine().split(" ");
		int n = Integer.parseInt(t[0]);
		int m = Integer.parseInt(t[1]);
		ArrayList<String> al = new ArrayList<String>();

		for(int i = 0; i < n; i++) {
			String temp = br.readLine();
			al.add(temp);
		}
		
		Collections.sort(al);
		String array[] = new String[al.size()];
		array = al.toArray(array);
		
		ArrayList<String> ans = new ArrayList<String>();
		
		for(int i = 0; i < m; i++) {
			String s = br.readLine();
			if(Arrays.binarySearch(array, s) >= 0){
				ans.add(s);
			}
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		for(String an : ans)
			System.out.println(an);
	}
	
}