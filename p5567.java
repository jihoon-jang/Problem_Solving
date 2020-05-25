import java.util.ArrayList;
import java.util.Scanner;

public class p5567 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		ArrayList<Integer> al[] = new ArrayList[n+2];
		
		for(int i = 1; i <= n; i++) 
			al[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			al[a].add(b);
			al[b].add(a);
		}
		
		int array[] = new int[n+2];
		for(int i = 0; i < al[1].size(); i++) {
			int student = al[1].get(i);
			array[student] = 1;
			friend(student, array, al);
		}
		
		int count = 0;
		for(int i = 0; i < array.length; i++)
			if(i != 1 && array[i] == 1) 
				count ++;			
		
		System.out.println(count);
	}
	
	public static void friend(int n, int array[], ArrayList<Integer> al[]) { 
		for(int i = 0; i < al[n].size(); i++) {
			int student = al[n].get(i);
			array[student] = 1;
		}
	}

} 