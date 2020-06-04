import java.util.*;

public class p1966 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();

		for(int t = 0; t < tc; t++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int answer = 1;
			LinkedList<Double> ll = new LinkedList<Double>();

			for(int i = 0; i < n; i++)
				ll.add((double)in.nextInt());

			ll.add(k, ll.get(k)+0.1);
			ll.remove(k+1);

			for(int i = 0; i < ll.size()-1; i++) {
				boolean max = true;
				
				for(int j = i+1; j < ll.size(); j++) {
					if(Math.floor(ll.get(i)) < Math.floor(ll.get(j))) {
						ll.add(ll.removeFirst());
						i = 0;
						k--;
						max = false;
						break;
					}
					
				}
				
				for(int a = 0; a < ll.size(); a++)
					System.out.print(ll.get(a)+" ");
				System.out.println(max);
				
				
				if(max) {
					double r = ll.remove(0);
					if(Math.floor(r) != r) {
						System.out.println(answer);
					}
					else 
						answer ++;
						
				}
			}
			
			System.out.println(answer);
			
		}
	}

}
