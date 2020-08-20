import java.util.*;

public class pmÄ³½Ã {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int cacheSize, String[] cities) {
		if(cacheSize == 0)
			return 5 * cities.length;
		LinkedList<String> list = new LinkedList<String>();
		int answer = 0;

		for(int i = 0; i < cities.length; i++) {
			String city = cities[i].toUpperCase();
			if(list.contains(city)) {
				list.remove(list.indexOf(city));
				list.addFirst(city);
				answer++;
			}
			else {
				if(list.size() == cacheSize)
					list.removeLast();
				list.addFirst(city);
				answer += 5;
			}
		}

		return answer;
	}
}