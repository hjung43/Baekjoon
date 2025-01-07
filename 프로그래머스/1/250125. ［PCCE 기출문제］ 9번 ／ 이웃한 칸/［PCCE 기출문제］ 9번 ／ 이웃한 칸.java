class Solution {
    public int solution(String[][] board, int h, int w) {
        //상우하좌 탐색배열
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        int boardH = board.length; //보드세로길이
        int boardW = board[0].length; //보드가로길이
        int answer = 0; //같은 색을 가진 인접칸 수
        //상우하좌 탐색
        for(int i=0; i<4; i++){
            //h,w에서 상우하좌 이동했을 때 보드를 넘어가지 않는지 확인
            if(h+dy[i]<boardH && h+dy[i]>=0 && w+dx[i]<boardW && w+dx[i]>=0){
                //넘어가지 않으면 h,w와 h+dy[i],w+dx[i]가 같은색인지 확인
                if(board[h][w].equals(board[h+dy[i]][w+dx[i]])){
                    answer++; //같은색이면 count추가
                }
            }
            
        }
        
        return answer;
    }
}