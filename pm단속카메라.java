import java.util.*;

class pm단속카메라 {
    public int solution(int[][] routes) {
        //나가는 시간, 들어온 시간 순 정렬
        Arrays.sort(routes, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int answer = 0;
        int index = -987654321;
        
        //출구에 카메라 설치 -> 다음 차의 입구가 카메라 index보다 크면 다시 설치
        for(int i = 0; i < routes.length; i++) {
            if(index < routes[i][0]) {
                answer++;
                index = routes[i][1];
            }
        }
        return answer;
    }
}