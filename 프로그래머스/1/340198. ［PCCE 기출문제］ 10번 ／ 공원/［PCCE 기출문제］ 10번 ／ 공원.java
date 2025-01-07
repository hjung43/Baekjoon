import java.lang.Math;
import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        
        Arrays.sort(mats); //돗자리 크기 정렬
        int answer = -1; //깔 수 있는 돗자리 크기 초기화
        int high = park.length; //공원높이
        int width = park[0].length; //공원너비
        //돗자리가 큰 순서부터 반복문 탐색
        loop1: for(int t=mats.length-1; t>=0; t--){
            //공원 전체를 돌면서 -1 찾기
            for(int h=0; h<high; h++){
                for(int w=0; w<width; w++){
                    if(park[h][w].equals("-1")){ //해당 위치가 -1 이면
                        //여기에 돗자리를 깔아도 공원을 넘어가지 않는지 확인
                        if(h+mats[t]-1<high && w+mats[t]-1<width){
                            boolean isValid = true;
                            //해당 위치부터 돗자리를 깔 수 있는지 확인
                            for (int i = 0; i < mats[t]; i++) {
                                for (int j = 0; j < mats[t]; j++) {
                                    if (!park[h + i][w + j].equals("-1")) { //못깔면 false
                                        isValid = false;
                                        break;
                                    }
                                }
                                if (!isValid) break;
                            }
                            if (isValid) { //돗자리를 깔 수 있었을 때
                                answer = mats[t];
                                return answer; //돗자리 크기 리턴
                            }
                        }
                    }
                }
            }
        }
        
        return answer; //반복문 다 돌았는데도 돗자리 못깔았을때 -1 리턴
    }
}
