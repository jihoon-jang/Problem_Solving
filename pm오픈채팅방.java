import java.util.*;

public class pm¿ÀÇÂÃ¤ÆÃ¹æ {
	
	public String[] solution(String[] record) {
		LinkedList<Chat> list = new LinkedList<Chat>();
		HashMap<String, String> map = new HashMap<String, String>();
		
		for(String com : record) {
			String s[] = com.split(" ");
			
			if(s[0].equals("Enter")) {
				list.add(new Chat(s[0].charAt(0), s[1]));
				map.put(s[1], s[2]);
			}
			else if(s[0].equals("Leave")) 
				list.add(new Chat(s[0].charAt(0), s[1]));
			else 
				map.put(s[1], s[2]);
		}
		
		String[] answer = new String[list.size()];
		
		for(int i = 0; i < answer.length; i++) {
			Chat now = list.poll();
			
			if(now.c == 'E') 
				answer[i] = map.get(now.id) + "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
			else
				answer[i] = map.get(now.id) + "´ÔÀÌ ³ª°¬½À´Ï´Ù.";
		}
		
		return answer;
	}
	
	class Chat {
		char c;
		String id;
		
		Chat(char c, String id) {
			this.c = c;
			this.id = id;
		}
	}
	
}