
public class pm징검다리건너기 {
	
    public int solution(int[] stones, int k) {
    	int answer = 0;
    	int max = stones[0], min = stones[0];
    	
    	for(int i = 0; i < stones.length; i++) {
    		max = Math.max(max, stones[i]);
    		min = Math.min(min, stones[i]);
    	}
    	
    	int mid;
    	
    	while(min <= max) {
    		mid = (min+max)/2;
    		if(check(k, stones.clone(), mid)) {
    			answer = Math.max(answer, mid);
    			min = mid + 1;
    		}
    		else
    			max = mid - 1; 
    	}
    	
        return answer;
    }
    
    public static boolean check(int k, int stones[], int value) {
    	for(int i = 0; i < stones.length; i++)
    		stones[i] -= value;
    	
    	int count = 0;
    	for(int i = 0; i < stones.length; i++) {
    		if(stones[i] < 0)
    			count++;
    		else
    			count = 0;
    		
    		if(count >= k)
    			return false;
    	}
    	
    	
    	return true;
    }
    
}