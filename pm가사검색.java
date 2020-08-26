public class pm가사검색 {

	public int[] solution(String[] words, String[] queries) {
		Trie trie[] = new Trie[10001];
		Trie rtrie[] = new Trie[10001];

		for(String word : words) { 
			int len = word.length();
			try {
				trie[len].insert(word.toCharArray());
			}
			catch(Exception e) {
				trie[len] = new Trie();
				trie[len].insert(word.toCharArray());
			}
			
			word = new StringBuilder(word).reverse().toString();
			try {
				rtrie[len].insert(word.toCharArray());
			}
			catch(Exception e) {
				rtrie[len] = new Trie();
				rtrie[len].insert(word.toCharArray());
			}
		}
		int[] answer = new int[queries.length];
		int index = 0;
		
		for(String query : queries) {
			if(query.indexOf("?") == 0) {
				query = new StringBuilder(query).reverse().toString();
				try {
				answer[index++] = rtrie[query.length()].search(query.toCharArray());
				}
				catch(Exception e) {
					continue;
				}
			}
			else {
				try {
				answer[index++] = trie[query.length()].search(query.toCharArray());
				}
				catch(Exception e) {
					continue;
				}
			}
		}

		return answer;
	}

	class Trie {
		int count;
		Trie child[];

		Trie() {
			count = 0;
			child = new Trie[26];
		}

		void insert(char cA[]) {
			Trie t = this;
			for(char c : cA) {
				t.count++;
				if(t.child[c-'a'] == null) {
					t.child[c-'a'] = new Trie();
					t = t.child[c-'a'];
				}
				else 
					t = t.child[c-'a'];
			}
		}
		
		int search(char cA[]) {
			Trie t = this;
			for(char c : cA) {
				if(c == '?')
					return t.count;
				
				if(t.child[c-'a'] == null)
					return 0;
				
				t = t.child[c-'a'];
			}
			
			return 0;
		}
	}
}