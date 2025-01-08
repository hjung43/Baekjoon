import java.lang.*;
import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        //델타: 북남서동
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        
        int px = park[0].length(); //공원의 가로길이
        int py = park.length; //공원의 세로길이
        char[][] park2 = new char[py][px]; //2차원 배열의 공원(편하기 위해서 만듦)
        
        //1차원 배열 공원을 2차원 배열로 옮겨줌
        for(int i=0; i<py; i++){
            for(int j=0; j<px; j++){
                park2[i][j]=park[i].charAt(j);
            }
        }
        
        int[] location = new int[2]; //산책현재위치
        
        //산책 시작점 찾기
        loop1:
        for(int i=0; i<py; i++){
            for(int j=0; j<px; j++){
                if(park2[i][j]=='S'){ //시작점 찾으면
                    //현재위치 배열에 저장
                    location[0]=i;
                    location[1]=j;
                    break loop1; //반복문 중지
                }
            }
        }
        //명령수만큼 반복
        for(int i=0; i<routes.length; i++){
            StringTokenizer st = new StringTokenizer(routes[i]); //방향과 칸수 구분
            String op = st.nextToken(); //방향저장
            int n = Integer.parseInt(st.nextToken()); //이동 칸 수 저장
            int m = -1; //방향에 따른 델타 인덱스 저장
            //방향 찾기
            if(op.equals("N")){
                m = 0;
            }else if(op.equals("S")){
                m = 1;
            }else if(op.equals("W")){
                m = 2;
            }else{
                m = 3;
            }
            //새로운 위치 갈 수 있는지 확인하기
            //새로운 위치 저장할 변수
            int ny = location[0]; 
            int nx = location[1];
            int cnt = 0; //한 방향으로 이동가능한 횟수
            //위에서 찾은 방향으로 n번 이동해보기
            for(int j=0; j<n; j++){
                //찾은 방향으로 한칸 이동했을때 공원크기를 넘어가지 않는지 확인
                if(ny+dy[m]>=0 && ny+dy[m]<py && nx+dx[m]>=0 && nx+dx[m]<px){
                    //찾은 방향으로 한칸 이동 했을 때 장애물 있는지 확인
                    if(park2[ny+dy[m]][nx+dx[m]]!='X'){
                        //없으면 이동
                        ny += dy[m];
                        nx += dx[m];
                        cnt++; //이동횟수 세기
                    }else{
                        break; //장애물 있으면 중지
                    }
                }else{
                    break; //공원 넘어가면 중지
                }
            }
            //이동횟수가 n이랑 같을때 (장애물 없이 다 이동 했을때)
            if(cnt == n){
                //현재위치 변경
                location[0]=ny;
                location[1]=nx;
            }  
            
        }
        return location;
    }
}