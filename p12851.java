import java.util.*;

public class p12851 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		int array[] = new int[200000];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		Arrays.fill(array, -1);
		array[n] = 0;
		boolean flag = false;
		int count = 0;

		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now == k) {
				count ++;
				flag = true;
			}

			if(!flag) {
				if(now+1 < 200000 && (array[now+1] > array[now] || array[now+1] == -1)) {
					array[now+1] = array[now]+1;
					q.add(now+1);
				}
				if(now-1 >= 0 && (array[now-1] > array[now] || array[now-1] == -1)) {
					array[now-1] = array[now]+1;
					q.add(now-1);
				}
				if(now*2 < 200000 && (array[now*2] > array[now] || array[now*2] == -1)) {
					array[now*2] = array[now] +1;
					q.add(now*2);
				}
			}
		}
		
		System.out.println(array[k]+"\n"+count);
	}

}
