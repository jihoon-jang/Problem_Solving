import java.util.*;

public class p10866 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		LinkedList<Integer> ll = new LinkedList<Integer>();

		for(int i = 0; i < n; i++) {
			String s = in.next();

			switch(s) {
			case "push_front" : ll.addFirst(in.nextInt());in.nextLine(); break;
			case "push_back" : ll.addLast(in.nextInt()); in.nextLine();break;
			case "pop_front" : 
				if(ll.isEmpty()) System.out.println(-1);
				else System.out.println(ll.removeFirst());	break;
			case "pop_back" : 
				if(ll.isEmpty()) System.out.println(-1);
				else System.out.println(ll.removeLast());	break;
			case "size" :
				System.out.println(ll.size()); break;
			case "empty" :
				System.out.println(ll.isEmpty() == true ? 1 : 0); break;
			case "front" :
				if(ll.isEmpty()) System.out.println(-1);
				else System.out.println(ll.getFirst());	break;
			case "back" :
				if(ll.isEmpty()) System.out.println(-1);
				else System.out.println(ll.getLast());	break;
			}
		}
	}

}
