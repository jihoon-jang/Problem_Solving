import java.util.PriorityQueue;

public class pm셔틀버스 {

	public static void main(String[] args) {
		String s[] = {"23:59"};

		System.out.println(solution(1,1, 1, s));
	}

	static PriorityQueue<Time> pq = new PriorityQueue<Time>();
	static String answer = "";
	public static String solution(int n, int t, int m, String[] Timetable) {
		for(int i = 0; i < Timetable.length; i++) {
			String s[] = Timetable[i].split(":");
			pq.add(new Time(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
		}

		bus(n, t, m);
		return answer;
	}

	public static void bus(int n, int t, int m) {
		Time bus = new Time(9, 0);
		Time corn = new Time(9, 0);

		//버스의 개수
		for(int i = 0; i < n; i++) {
			int people = 0;
			
			//각 버스마다 탑승하는 인원(0~m)
			for(int j = 0; j < m; j++) {
				if(!pq.isEmpty()) {
					Time temp = pq.peek();

					//버스에 탑승 가능한 인원
					if(bus.compareTo(temp) >= 0) {
						corn = pq.poll();
						people++;
					}
				}
				//마지막 버스에 사람이 가득 찬 경우
				if(i == n-1 && people == m) {
					corn = new Time(corn.h, corn.m-1);
				}
				//마지막 버스에 자리가 남는 경우
				else if(i == n-1 && people < m) {
					corn = new Time(bus.h, bus.m);
				}
			}
			//다음 버스 도착 시간
			bus = new Time(bus.h, bus.m+t);
		}
		//콘의 시간을 String으로 정제
		answer += (corn.h < 10 ? "0"+corn.h : corn.h)+":"+ (corn.m<10?"0"+corn.m : corn.m);
	}

	static class Time implements Comparable<Time>{
		int h, m;

		Time(int h, int m) {
			if(m < 0) {
				m += 60;
				h--;
			}

			if(m >= 60) {
				m -= 60;
				h++;
			}
			this.h = h;
			this.m = m;
		}

		public int compareTo(Time o) {
			if(h == o.h)
				return m - o.m;
			return h-o.h;
		}
	}
}