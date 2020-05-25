import java.util.*;
public class p14888 {
	static ArrayList<Integer> al;
	static int op[];//+,-,x,/
	static int n;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		al = new ArrayList<Integer>();
		for(int i = 0; i < n; i++)
			al.add(in.nextInt());
		op = new int[4];
		for(int i = 0; i < 4; i++)
			op[i] = in.nextInt();

		int tem[] = new int[4];
		for(int x = 0; x < 4; x++)
			tem[x] = op[x];
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int z = 0; z < al.size(); z++)
				temp.add(al.get(z));
		for(int i = 0; i < 4; i++) {
			al.clear();
			for(int z = 0; z < temp.size(); z++)
				al.add(temp.get(z));
			for(int x = 0; x < 4; x++)
				op[x] = tem[x];
			cal(i);
		}
		System.out.println(max + "\n" + min);
	}

	public static void cal(int opindex) {
		if(al.size() == 1) {
			max = Math.max(max, al.get(0));
			min = Math.min(min, al.get(0));
			return;
		}
		if(op[opindex] == 0)
			return;
		int n1 = al.get(0);
		int n2 = al.get(1);
		al.remove(0);
		al.remove(0);
		switch(opindex) {
		case 0 : al.add(0, n1+n2); op[0]--; break;
		case 1 : al.add(0, n1-n2); op[1]--; break;
		case 2 : al.add(0, n1*n2); op[2]--; break;
		case 3 : al.add(0, n1/n2); op[3]--; break;
		}

		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i < al.size(); i++)
			temp.add(al.get(i));
		int tem[] = new int[4];
		for(int i = 0; i < 4; i++)
			tem[i] = op[i];
		for(int i = 0; i < 4; i++) {
			al.clear();
			for(int j = 0; j < temp.size(); j++)
				al.add(temp.get(j));
			
		for(int z = 0; z < 4;z++)
			op[z] = tem[z];
			cal(i);
		}
	}

}
