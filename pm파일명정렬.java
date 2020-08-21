import java.util.*;

public class pm파일명정렬 {

	public static String[] solution(String[] files) {
		PriorityQueue<File> pq = new PriorityQueue<File>();
		String head, number;
		
		for(int i = 0; i < files.length; i++) {
			head = "";
			number = "";
			String file = files[i];
			for(int j = 0; j < file.length(); j++) {
				if(number.length() == 5)
					break;
				if(file.charAt(j) >= '0' && file.charAt(j) <= '9') {
					if(number.length() == 0)
						head = file.substring(0, j);
					number += file.charAt(j);
				}
                else {
                    if(number.length() != 0)
                        break;
                }
            }
			pq.add(new File(head, number, file, i));
		}

		String answer[] = new String[pq.size()];
		int index = 0;
		
		while(!pq.isEmpty())
			answer[index++] = pq.poll().origin;
		return answer;
	}

	static class File implements Comparable<File>{
		String head, number, origin;
		int index;

		File(String head, String number, String origin, int index) {
			this.head = head;
			this.number = number;
			this.origin = origin;
			this.index = index;
		}

		public int compareTo(File f) {
			if(head.toLowerCase().compareTo(f.head.toLowerCase()) == 0) {
				if(Integer.parseInt(number) - Integer.parseInt(f.number) == 0)
					return index - f.index;
				return Integer.parseInt(number) - Integer.parseInt(f.number);
			}

			return head.toLowerCase().compareTo(f.head.toLowerCase());
		}
	}
}