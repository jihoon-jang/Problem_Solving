import java.util.PriorityQueue;
import java.util.Scanner;

public class p1927 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PriorityQueue pq = new PriorityQueue();
		int n = in.nextInt();

		for(int i = 0; i < n; i++) {
			int number = in.nextInt();
			if(number != 0)
				pq.add(number);
			else {
				if(pq.isEmpty())
					System.out.println(0);
				else
					System.out.println(pq.poll());
			}
		}

	}

}
