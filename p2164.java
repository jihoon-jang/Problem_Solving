import java.util.LinkedList;
import java.util.Scanner;

public class p2164 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for(int i = 0; i < n; i++) 
			ll.add(i+1);
		
		while(ll.size() != 1) {
			ll.removeFirst();
			ll.add(ll.removeFirst());
		}
		System.out.println(ll.get(0));

	}

}
