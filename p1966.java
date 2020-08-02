import java.util.*;

public class p1966 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();

		for(int t = 0; t < tc; t++) {
			int answer = 1;
			int n = in.nextInt();
			int m = in.nextInt();
			LinkedList<Double> ll = new LinkedList<Double>();
			for(int i = 0; i < n; i++) {
				double d = in.nextDouble();
				if(i == m)
					d += 0.1;
				ll.add(d);
			}
			
			while(true) {
				boolean del = true;
				for(int i = 1; i < ll.size(); i++) {
					if(Math.floor(ll.get(0)) < Math.floor(ll.get(i))) {
						ll.addLast(ll.removeFirst());
						del = false;
						break;
					}
				}
				if(del) {
					if(ll.get(0) != Math.floor(ll.get(0))) {
						System.out.println(answer);
						break;
					}
					else {
						ll.removeFirst();
						answer++;
					}
				}
				
			}
			
		}
		
		in.close();
	}

}
