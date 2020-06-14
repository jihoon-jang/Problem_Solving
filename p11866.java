import java.util.ArrayList;
import java.util.Scanner;

public class p11866 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		ArrayList<Integer> al = new ArrayList();
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i = 1; i <= n; i++)
			al.add(i);

		int index = 0;
		while(!al.isEmpty()) {
			index += k-1;
			if(index > al.size()-1)
				index %= al.size();
			sb.append(al.get(index)+", ");
			al.remove(index);
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.println(sb.toString());
	}

}