import java.util.*;

public class pm다트게임 {
    public int solution(String dartResult) {
        Stack<Integer> st = new Stack<Integer>();
        st.add(0);
        int now, before;
        
        for(int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            switch(c) {
                case 'S': break;
                case 'D': st.push((int)Math.pow(st.pop(), 2)); break;
                case 'T': st.push((int)Math.pow(st.pop(), 3)); break;
                case '*': 
                    now = st.pop() * 2; 
                    before = st.pop() * 2; 
                    st.push(before);
                    st.push(now);
                    break;
                case '#': st.push(st.pop() * -1); break;
                default: 
                    now = 1;
                    now *= c-'0'; 
                    c = dartResult.charAt(i+1);
                    if('0' <= c && c <= '9'){
                        now *= 10;
                        now += c-'0';
                        i++;
                    }
                    st.push(now);
            }
        }
        int sum = 0;
        
        while(!st.isEmpty())
          sum += st.pop();
          
        return sum;
    }
}