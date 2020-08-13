import java.util.*;
import java.io.*;

public class p2143 {
	static int t, a[], b[];
	static long answer;
	static ArrayList<Integer> al = new ArrayList<Integer>();
	static ArrayList<Integer> bl = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		answer = 0;
		int n = Integer.parseInt(br.readLine());
		a = new int[n];

		StringTokenizer stz = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			a[i] = Integer.parseInt(stz.nextToken());

		int sum;
		for(int i = 0; i < n; i++) {
			sum = 0;
			for(int j = i; j < n; j++) {
				sum += a[j];
				al.add(sum);
			}
		}

		n = Integer.parseInt(br.readLine());
		b = new int[n];
		stz = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			b[i] = Integer.parseInt(stz.nextToken());

		for(int i = 0; i < n; i++) {
			sum = 0;
			for(int j = i; j < n; j++) {
				sum += b[j];
				bl.add(sum);
			}
		}

		Collections.sort(al);
		Collections.sort(bl);
		search();
		System.out.println(answer);
	}

	public static void search() {
		int andex = 0;
		int bndex = bl.size() - 1;
		long sum;
		while(andex < al.size() && bndex >= 0) {
			sum = al.get(andex) + bl.get(bndex);
			
			if(sum == t) { 
				long acount = 0;
				int aValue = al.get(andex);
				long bcount = 0;
				int bValue = bl.get(bndex);	

				while(andex < al.size() && al.get(andex) == aValue) {
					acount++;
					andex++;
				}	
				while(bndex >= 0 && bl.get(bndex) == bValue) {
					bcount++;
					bndex--;
				}
				
				answer += acount*bcount;
			}
			else if(sum > t) 
				bndex--;
			else
				andex++;
		}
	}

}

