class pm네트워크 {
    
    boolean visit[];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                dfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int number, int n, int computers[][]) {
        if(!visit[number]) {
            visit[number] = true;
            
            for(int i = 0; i < n; i++) {
                if(computers[number][i] == 1)
                    dfs(i, n, computers);
            }
        }
    }
}