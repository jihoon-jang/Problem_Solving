import java.util.*;

public class pm호텔방배정 {
	
	public Map<Long, Long> map = new HashMap<Long, Long>();
	
	public long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
		
		for(int i = 0; i < answer.length; i++) {
			long room = room_number[i];
			answer[i] = getRoom(room);
		}
		
		return answer;
	}
	
	public long getRoom(long number) {
		if(!map.containsKey(number)) {
			map.put(number, number+1);
			
			return number;
		}
		
		map.put(number, getRoom(map.get(number)));
		
		return map.get(number);
	}
	
}