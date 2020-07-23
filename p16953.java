import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p16953 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		Queue<value> q = new LinkedList<value>();

		q.add(new value(a, 1));
		makeNumber(q, b);
		in.close();
	}

	public static void makeNumber(Queue<value> q, int b) {
		while(!q.isEmpty()) {
			value v = q.poll();
			
			if(v.num == b) {
				System.out.println(v.count);
				return;
			}

			if(v.num*2 <= 1000000000)
				q.add(new value(v.num *2, v.count+1));
			if(v.num*10+1 <= 1000000000)
				q.add(new value(v.num *10+1, v.count+1));
		}
		
		System.out.println(-1);
	}
}

class value{
	long num;
	int count;
	value(long l, int count) {
		this.num = l;
		this.count = count;
	}
}