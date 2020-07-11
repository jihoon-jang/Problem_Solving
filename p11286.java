import java.util.*;

public class p11286 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				if(Math.abs(arg0) == Math.abs(arg1))
					return arg0 - arg1;
				return Math.abs(arg0) - Math.abs(arg1);
			}
			
		});

		for(int i = 0; i < n; i++) {
			int val = in.nextInt();
			if(val != 0) 
				pq.add(val);
			else {
				if(pq.size() == 0)
					System.out.println(0);
				else
					System.out.println(pq.poll());
			}
		}

		

	}

}
