import java.util.*;

public class pmæ–√‡ {
	public static int[] solution(String msg) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();

		for(int i = 0; i < 26; i++) {
			char c = (char)('A' + i);
			map.put(""+c, i+1);
		}
		int mapIndex = 27;

		for(int i = 0; i < msg.length(); i++){
			int index = 1;

			while(i+ index+1 <= msg.length() && map.containsKey(msg.substring(i, i+index+1))) {
				index++;
			}
			String s = msg.substring(i, i+index);
			int j = i;
			i += index-1;
			al.add(map.get(s));

			while(j+index+1 <= msg.length() && !map.containsKey(msg.substring(j, j+index+1))) {
				s = msg.substring(j, j+index);
				index++; 
				break;
			}
			s = msg.substring(j, j+index);

			if(!map.containsKey(s)) {
				map.put(s, mapIndex++);
			}
		}

		int answer[] = new int[al.size()];
		for(int i = 0; i < al.size(); i++)
			answer[i] = al.get(i);

		return answer;
	}
}
