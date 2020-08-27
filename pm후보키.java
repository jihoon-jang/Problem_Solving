import java.util.*;

public class pmÈÄº¸Å° {

	public ArrayList<HashSet> al = new ArrayList<HashSet>();
	public String relation[][];

	public int solution(String[][] relation) {
		this.relation = relation;

		for(int i = 1; i <= relation[0].length; i++)
			per(0, 0, i, new boolean[relation[0].length], "");

		return al.size();
	}

	public void per(int length, int start, int end, boolean visit[], String s) {
		if(length == end) {
			check(s.split(" "));
			return;
		}

		for(int i = start; i < relation[0].length; i++) {
			if(!visit[i]) {
				visit[i] = true;
				per(length+1, i, end, visit, s+i+" ");
				visit[i] = false;
			}
		}
	}

	public void check(String s[]) {
		int num[] = new int[s.length];
		HashSet<String> set = new HashSet<String>();
		HashSet<Integer> key = new HashSet<Integer>();

		for(int i = 0; i < s.length; i++) {
			num[i] = Integer.parseInt(s[i]);
			key.add(num[i]);
		}

		for(int i = 0; i < relation.length; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < num.length; j++) 
				sb.append(relation[i][num[j]]+",");
			if(set.contains(sb.toString()))
				return;
			set.add(sb.toString());
		}
		for(int i = 0; i < al.size(); i++) {
			HashSet temp = al.get(i);
			int count = 0;

			for(int j = 0; j < num.length; j++) {
				if(temp.contains(num[j]))
					count++;
				if(count == temp.size())
					return;
			}
		}

		al.add(key);
	}

}