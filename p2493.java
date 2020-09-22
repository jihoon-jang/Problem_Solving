import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class p2493 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.parseInt(br.readLine());
		StringTokenizer stz = new StringTokenizer(br.readLine());
		Stack<Integer> st = new Stack<>();
		for(int i = 0; i < loop; i++)
			st.push(Integer.parseInt(stz.nextToken()));
		PriorityQueue<Top> pq = new PriorityQueue<>();
		int answer[] = new int[loop+1];
		
		while(!st.isEmpty()) {
			int now = st.pop();
			if(!pq.isEmpty()) {
				while(!pq.isEmpty() && pq.peek().value <= now){
					Top t = pq.poll();
					answer[t.index] = st.size()+1;
				}
			}
			
			pq.offer(new Top(now, loop--));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < answer.length; i++)
			sb.append(answer[i] + " ");
		System.out.println(sb.toString());
	}
	
	static class Top implements Comparable<Top> {
		int value, index;
		
		Top(int v, int i) {
			this.value = v;
			this.index = i;
		}
		
		public int compareTo(Top t){
			return value - t.value;
		}
	}
}
