import java.util.Scanner;

public class p1541 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String m[] = s.split("-");
		int init = 0;
		String sum[] = m[0].split("\\+");
		for(String n : sum)
			init += Integer.parseInt(n);

		for(int i = 1; i < m.length; i++) {
			sum = m[i].split("\\+");
			for(String n : sum)
				init -= Integer.parseInt(n);
		}
		System.out.println(init);
	}

}
