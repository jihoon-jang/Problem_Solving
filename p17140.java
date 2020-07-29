import java.io.*;
import java.util.*;

public class p17140 {
	static int r, c, k, map[][], xNum, yNum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		r = Integer.parseInt(stz.nextToken());
		c = Integer.parseInt(stz.nextToken());
		k = Integer.parseInt(stz.nextToken());
		xNum = 3;
		yNum = 3;
		map = new int[100][100];

		for(int i = 0; i < 3; i++) {
			stz = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++)
				map[i][j] = Integer.parseInt(stz.nextToken());
		}
		
		cal();
	}

	public static void cal() {
		int answer = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		Iterator it;

		while(map[r-1][c-1] != k) {
			if(answer == 101)
				break;
			
			if(xNum >= yNum) {
				for(int i = 0; i < xNum; i++) {
					hashMap.clear();
					pq.clear();
					clear(true, i);
					
					for(int j = 0; j < yNum; j++) {
						int now = map[i][j];
						if(now == 0)
							continue;
						if(hashMap.containsKey(now))
							hashMap.put(now, hashMap.get(now)+1);
						else
							hashMap.put(now, 1);
					}
					 it = hashMap.keySet().iterator();

					while(it.hasNext()){
						int key = (int)it.next();
						pq.add(new Node(key, hashMap.get(key)));
					}
					
					int index = 0;
					while(!pq.isEmpty()) {
						if(index == 100)
							break;
						
						Node node = pq.poll();
						int number = node.number;
						int count = node.count;
						map[i][index++] = number;
						map[i][index++] = count;
						
						if(index > yNum)
							yNum = index;
					}
				}
			}
			else {
				for(int i = 0; i < yNum; i++) {
					hashMap.clear();
					pq.clear();
					clear(false, i);
					
					for(int j = 0; j < xNum; j++) {
						int now = map[j][i];
						if(now == 0)
							continue;
						if(hashMap.containsKey(now))
							hashMap.put(now, hashMap.get(now)+1);
						else
							hashMap.put(now, 1);
					}
					
					it = hashMap.keySet().iterator();
					
					while(it.hasNext()){
						int key = (int)it.next();
						pq.add(new Node(key, hashMap.get(key)));
					}
					
					int index = 0;
					while(!pq.isEmpty()) {
						if(index == 100)
							break;
						
						Node node = pq.poll();
						int number = node.number;
						int count = node.count;
						map[index++][i] = number;
						map[index++][i] = count;
						
						if(index > xNum)
							xNum = index;
					}
				}
			}
			answer ++;
		}
		System.out.println(answer > 100 ? -1 : answer);
	}
	
	public static void clear(boolean x, int line) {
		if(x) {
			for(int i = 0; i < 100; i++)
				map[line][i] = 0;
		}
		else
			for(int i = 0; i < 100; i++)
				map[i][line] = 0;
	}

	static class Node implements Comparable<Node> {
		int number;
		int count;
		Node(int number, int count) {
			this.number = number;
			this.count = count;
		}

		public int compareTo(Node o) {
			if(count == o.count)
				return number-o.number;
			return count - o.count;
		}
	}
}
