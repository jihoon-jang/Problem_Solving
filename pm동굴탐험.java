import java.util.*;

class Solution {
	
	public int n;
	public int before[], after[];
	public ArrayList<Integer> al[];
	public boolean visit[];
	
    public boolean solution(int n, int[][] path, int[][] order) {
    	this.n = n;
    	before = new int[n];
    	after = new int[n];
    	visit = new boolean[n];
    	al = new ArrayList[n];
    	
    	for(int i = 0; i < n; i++)
    		al[i] = new ArrayList<Integer>();
    	
    	for(int i = 0; i < path.length; i++) {
    		int a = path[i][0];
    		int b = path[i][1];
    		al[a].add(b);
    		al[b].add(a);
    	}
    	
    	for(int i = 0; i < order.length; i++)
    		before[order[i][1]] = order[i][0];
    	
    	if(before[0] != 0)
    		return false;
    	
    	Stack<Integer> st = new Stack<Integer>();
    	visit[0] = true;
    	
    	for(int i = 0; i < al[0].size(); i++)
    		st.add(al[0].get(i));
    	
    	while(!st.isEmpty()) {
    		int now = st.pop();
    		
    		if(visit[now])
    			continue;
    		if(!visit[before[now]]) {
    			after[before[now]] = now;
    			continue;
    		}
    		
    		visit[now] = true;
    		for(int i = 0; i < al[now].size(); i++)
    			st.add(al[now].get(i));
    		st.add(after[now]);
    	}
    	
        for(int i = 0; i < n; i++)
        	if(!visit[i])
        		return false;
        
        return true;
    }
    
}