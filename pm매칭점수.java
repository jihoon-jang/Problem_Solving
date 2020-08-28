import java.util.*;

public class pm¸ÅÄªÁ¡¼ö {

	public LinkedList<Url> list = new LinkedList<Url>();
	public Map<String, Integer> map = new HashMap<String, Integer>();

	public int solution(String word, String[] pages) {
		for(int i = 0; i < pages.length; i++) {
			String page = pages[i];
			int left = 0;
			int right = 0;
			int mid = 0;
            
			while(mid <= left) {
				left = page.indexOf("<meta", left+1);
				right = page.indexOf(">", left);
				mid = page.lastIndexOf("https://", right);
			}
            right = page.indexOf("\"", mid);
			String url = page.substring(mid, right);
			map.put(url, i);
			list.add(new Url(i, url));

			left = page.indexOf("<body>");
			right = page.indexOf("</body>");
			String body = page.substring(left + 6, right);
			list.get(i).setScore(body, word.toLowerCase());
			list.get(i).setOuter(body);
		}

		for(int i = 0; i < list.size(); i++) {
			Url now = list.get(i);
			now.match += now.score;
			Stack<String> st = now.st;
			while(!st.isEmpty()) {
				String temp = st.pop();
				if(map.containsKey(temp)) {
					int val = map.get(temp);
					list.get(val).match += (double)now.score/now.outer;
				}
			}
		}

		Collections.sort(list, new Comparator<Url>() {
			public int compare(Url u1, Url u2) {
				if(u1.match == u2.match)
					return u1.index - u2.index;
				return Double.compare(u2.match, u1.match);
			}
		});

		return list.get(0).index;
	}

	class Url {
		Stack<String> st = new Stack<String>();
		int index;
		String name;
		int score = 0;
		int outer = 0;
		double match = 0;

		Url(int i, String n){
			index = i;
			name = n;
		}

		void setScore(String body, String word) {
			body = body.toLowerCase();
			for(int i = 0; i < body.length(); i++) {
				char c = body.charAt(i);
				if(c < 'a' || c > 'z')
					body = body.replace(c, ' ');
			}
			String s[] = body.split(" ");
			for(String sT : s)
				if(word.equals(sT))
					score++;
		}

		void setOuter(String body) {
			int left, right;

			while(body.contains("<a href=\"")) {
				left = 0;
				right = 0;
				left = body.indexOf("<a href=\"");
				right = body.indexOf("\">",left);

				String link = body.substring(left+9, right);
				body = body.substring(right, body.length());
				outer++;
				st.push(link);
			}
		}

	}

}