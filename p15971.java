import java.util.*;
public class p15971 {
	static Scanner in = new Scanner(System.in);  
	static int size = in.nextInt();
	static int robot1 = in.nextInt();
	static int robot2 = in.nextInt();
	static ArrayList<po> al[];
	static boolean visit[];
	static int answer = 0;
	static int max = 0;

	public static void main(String[] args) {
		al = new ArrayList[size+1];
		visit = new boolean[size+1];
		for(int i = 1; i <= size; i++) {
			al[i] = new ArrayList();
		}
		makemap();
		bfs(robot1, answer, max);
	}

	public static void bfs(int n, int ans, int m) {
		visit[n] = true;
		if(n == robot2) {
			System.out.println(ans - m);
			return;
		}

		for(int i = 0; i < al[n].size(); i++) {
			if(!visit[al[n].get(i).number]) {
				visit[al[n].get(i).number] = true;
				bfs(al[n].get(i).number, ans + al[n].get(i).weight,
						m > al[n].get(i).weight ? m : al[n].get(i).weight);
			}
		}
	}
	
	public static void makemap() {
		for(int i = 0; i < size - 1; i++) {
			int x = in.nextInt();
			int y = in.nextInt(); 
			int w = in.nextInt();
			int temp = 0;
			if(x > y) {
				temp = x;
				x = y;
				y = temp;
			}
			po p1 = new po(y, w);
			po p2 = new po(x, w);
			al[x].add(p1);
			al[y].add(p2);
		}
	}

}

class po {
	int number;
	int weight;
	po(){}
	po(int n, int w) {
		this.number = n;
		this.weight = w;
	}

}
