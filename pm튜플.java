import java.util.*;

class pm∆©«√ {

	public int[] solution(String s) {
		s = s.substring(1, s.length()-1);
		ArrayList<String> numbers = new ArrayList<String>();
		int left = -1;
		int right = 0;

		while(right < s.length()-1) {
			left = s.indexOf("{", left+1);
			right = s.indexOf("}", left + 1);
			numbers.add(s.substring(left+1, right));
		}
		ArrayList<String[]> number = new ArrayList<String[]>();

		for(int i = 0; i < numbers.size(); i++) 
			number.add(numbers.get(i).split(","));

		Collections.sort(number, new Comparator<String[]>() {
			public int compare(String s1[], String s2[]) {
				return s1.length - s2.length;
			}
		});

		Set<Integer> set = new LinkedHashSet<Integer>();

		for(int i = 0; i < number.size(); i++) {
			String temp[] = number.get(i);
			for(int j = 0; j < temp.length; j++) {
				int n = Integer.parseInt(temp[j]);
				set.add(n);
			}
		}

		Iterator<Integer> it = set.iterator();
		int[] answer = new int[set.size()];
		int index = 0;

		while(it.hasNext())
			answer[index++] = it.next();

		return answer;
	}

}
