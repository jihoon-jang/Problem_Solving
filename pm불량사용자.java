import java.util.*;

class pm불량사용자 {
	
	public Set<Set<String>> answer;
	
    public int solution(String[] user_id, String[] banned_id) {
    	answer = new HashSet<>();
    	dfs(user_id, banned_id, new LinkedHashSet<String>());
    	
        return answer.size();
    }
    
    public void dfs(String[] user_id, String[] banned_id, Set<String> set) {
    	if(set.size() == banned_id.length) {
    		if(possBan(banned_id, set)) 
    			answer.add(new HashSet<>(set));
    		return;
    	}
    	
    	for(String user : user_id) {
    		if(!set.contains(user)) {
    			set.add(user);
    			dfs(user_id, banned_id, set);
    			set.remove(user);
    		}
    	}
    }
    
    public boolean possBan(String[] banned_id, Set<String> set) {
    	int index = 0;
    	
    	for(String id : set) {
    		if(!equal(banned_id[index++], id))
    			return false;
    	}
    	return true;
    }
    
    public boolean equal(String s1, String s2) {
    	if(s1.length() != s2.length())
    		return false;
    	
    	for(int i = 0; i < s1.length(); i++) {
    		if(s1.charAt(i) == '*')
    			continue;
    		
    		if(s1.charAt(i) != s2.charAt(i))
    			return false;
    	}
    	
    	return true;
    }
    
}