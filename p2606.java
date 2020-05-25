import java.util.*;
public class p2606 {
	static int answer = -1;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		ArrayList<Integer>[] al = new ArrayList[size+1]; 
		boolean visit[] = new boolean[size+1];

		for(int i = 1; i <= size; i++)
			al[i] = new ArrayList<Integer>();
		int loop = in.nextInt();
		for(int l = 0; l < loop; l++) {
			int n1 = in.nextInt();
			int n2 = in.nextInt();
			al[n1].add(n2);
			al[n2].add(n1);
		}
		dfs(al, visit, 1);
		System.out.println(answer);
	}

	public static void dfs(ArrayList<Integer>[] al, boolean visit[], int number) {
		int a = 0;
		if(!visit[number])
			answer++;
		visit[number] = true;
		while(!al[number].isEmpty()) {
			a++;
			if(a==100)
				return;
			int n = al[number].get(0);
			al[number].remove(0);
			if(!al[n].isEmpty())
				al[n].remove(al[n].indexOf(number));
			dfs(al,visit,n);
		}
	}

}
