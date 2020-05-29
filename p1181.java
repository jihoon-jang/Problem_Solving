import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p1181 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);	

		int n = in.nextInt();
		in.nextLine();
		ArrayList<String> al[] = new ArrayList[51];
		for(int i = 0; i <= 50; i++)
			al[i] = new ArrayList<String>();

		for(int i = 0; i < n; i++) {
			String s = in.nextLine();
			al[s.length()].add(s);
		}

		for(int i = 0; i <= 50; i++)
			Collections.sort(al[i]);

		for(int i = 0; i <= 50; i++)
			for(int j = 0; j < al[i].size(); j++)
				if(j > 0 && al[i].get(j).equals(al[i].get(j-1))) {}
				else
					System.out.println(al[i].get(j));
	}

}
