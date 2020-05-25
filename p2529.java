import java.util.ArrayList;
import java.util.Scanner;

public class p2529 {
	static int n;
	static char c[];
	static boolean visit[] = new boolean[10];
	static ArrayList<String> al = new ArrayList<String>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		c = new char[n];
		for(int i = 0; i < n; i++)
			c[i] = in.next().charAt(0);

		for(int i = 0; i < 10; i++) {
			visit[i] = true;
			f(0, i, i+"");
			visit[i] = false;
		}
		System.out.println(al.get(al.size()-1)+"\n"+al.get(0));
	}

	public static void f(int index, int num, String s) {
		if(index == n) {
			al.add(s);
			return;
		}
		else {
			for(int i = 0; i < 10; i++) {
				if(!visit[i]) {
					char op = c[index];
					switch(op) {
					case '>' :
						if(num > i) {
							visit[i] = true;
							f(index + 1, i, s+i);
							visit[i] = false;
						}
						break;
					case '<' :
						if(num < i) {
							visit[i] = true;
							f(index + 1, i, s+i);
							visit[i] = false;
						}
						break;
					}
				}
			}
		}
	}

}
