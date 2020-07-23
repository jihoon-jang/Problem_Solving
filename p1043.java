import java.util.Scanner;

public class p1043 {
	static int n, m, parent[], k, man[], answer = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		m = in.nextInt();
		parent = new int[n+1];
		k = in.nextInt();
		man = new int[k];

		for(int i = 1; i <= n; i++)
			parent[i] = i;

		for(int i = 0; i < k; i++) 
			man[i] = in.nextInt();

		String party[] = new String[m];

		for(int i = 0; i < m; i++) {
			int partyPeople = in.nextInt();
			party[i] = in.nextLine().trim();
			String s[] = party[i].split(" ");

			if(s.length > 1)
				for(int j = 0; j < partyPeople-1; j++) {
					union(Integer.parseInt(s[j]), Integer.parseInt(s[j+1]));
				}
		}

		check(party);
		
		System.out.println(answer);
	}

	public static void check(String[] party) {
		l: for(int i = 0; i < party.length; i++) {
			if(party[i].length() >= 1) {
				int target = parent[find(Integer.parseInt(party[i].split(" ")[0]))];

				for(int j = 0; j < man.length; j++) {
					if(target == parent[find(man[j])])
						continue l;
				}

				answer ++;
			}
		}
	}

	public static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);

		if(p1 < p2) 
			parent[p2] = p1;
		else 
			parent[p1] = p2;
	}

	public static int find(int n) {
		if(parent[n] == n)
			return n;
		else
			return parent[n] = find(parent[n]);
	}

}