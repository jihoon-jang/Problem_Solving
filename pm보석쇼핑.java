import java.util.*;

public class pm∫∏ºÆºÓ«Œ {
    
	public Map<String, Integer> map = new HashMap<String, Integer>();
	public int answer[];

	public int[] solution(String[] gems) {

		for(String gem : gems) {
			if(map.containsKey(gem))
				map.put(gem, map.get(gem) + 1);
			else
				map.put(gem, 1);
		}

		search(gems);
		opt(gems);
		
		return answer;
	}

	public void search(String[] gems) {
		int left = 0;
		int right = gems.length-1;

		boolean finish = false;

		while(!finish) {
			finish = true;
			if(map.get(gems[right]) > 1) {
				map.put(gems[right], map.get(gems[right])-1);
				right--;
				finish = false;
			}
		}

		finish = false;
		while(!finish) {
			finish = true;
			if(map.get(gems[left]) > 1) {
				map.put(gems[left], map.get(gems[left])-1);
				left++;
				finish = false;
			}
		}
		answer = new int[] {left+1, right+1};

	}

	public void opt(String[] gems) {
		int left = answer[0] - 1;
		int right = answer[1] - 1;
		int len = right - left;

		while(right < gems.length-1) {
			map.put(gems[left], map.get(gems[left])-1);
			left++;
			right++;
			map.put(gems[right], map.get(gems[right])+1);

			boolean b = false;
			while(!map.containsValue(0)) {
				while(!map.containsValue(0)) {
					b = true;
					map.put(gems[right], map.get(gems[right])-1);
					right--;
				}
				if(b) {
					right++;
					map.put(gems[right], map.get(gems[right])+1);
				}

				b = false;
				while(!map.containsValue(0)) {
					b = true;
					map.put(gems[left], map.get(gems[left])-1);
					left++;
				}
				if(b){
					left--;
					map.put(gems[left], map.get(gems[left])+1);
				}

				if(right-left == len)
					break;
				if(right-left < len) {
					answer = new int[] {left+1, right+1};
					len = right - left;
				}
			}

		}
	}

}