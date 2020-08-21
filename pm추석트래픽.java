import java.util.*;

public class pm추석트래픽 {
	
	static PriorityQueue<Log> start = new PriorityQueue<Log>();
	static PriorityQueue<Log> end = new PriorityQueue<Log>();
	
	public int solution(String[] lines) {
		for(int i = 0; i < lines.length; i++) {
			String line[] = lines[i].split(" ");
			int h = Integer.parseInt(line[1].substring(0,2));
			int m = Integer.parseInt(line[1].substring(3,5));
			double s = Double.parseDouble(line[1].substring(6,12));
			double time = Double.parseDouble(line[2].substring(0, line[2].length()-1))-0.001;

			start.add(new Log(h, m, s,time));
			end.add(new Log(h, m, s));
		}

		return count();
	}
    
	public static int count() {
		int answer = 0;
		int temp = 0;
		Log now;

		while(!start.isEmpty()) {
			now = start.poll();
			temp++;

			if(end.peek().diff(now) <= 999) 
				answer = Math.max(temp, answer);

			while(end.peek().diff(now) >= 1000) {
				end.poll();
				temp--;
			}
			answer = Math.max(temp, answer);

		}

		return answer;
	}

	class Log implements Comparable<Log> {
		int h, m, s;

		Log(int h, int m, double s) {
			if(s < 0) {
				m--;
				s += 60000;
			}
			if(m < 0) {
				h--;
				m += 60000;
			}

			this.h = h;
			this.m = m;
			this.s = (int)(s*1000);
		}

		Log(int h, int m, double s, double time) {
			this.h = h;
			this.m = m;
			this.s = (int)(s*1000) - (int)(time*1000);
			
			if(this.s < 0) {
				this.m--;
				this.s += 60000;
			}
			if(m < 0) {
				this.h--;
				this.m += 60000;
			}
		}
		
		public int diff(Log l) {
			int value1 = h *3600000 + m * 60000 + s;
			int value2 = l.h * 3600000 + l.m * 60000 + l.s;

			return value2-value1;
		}

		public int compareTo(Log l) {
			if(h == l.h) {
				if(m == l.m){
					return (int) (s - l.s);
				}
				return m - l.m;
			}
			return h - l.h;
		}
	}
}