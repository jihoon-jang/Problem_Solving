import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class p11279 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PriorityQueue pq = new PriorityQueue(new Comparator<Integer>() {
			
			public int compare(Integer o1, Integer o2) {
				
				return o2.compareTo(o1);
			}
			
		});
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
