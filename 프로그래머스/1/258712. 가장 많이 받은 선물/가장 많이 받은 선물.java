import java.lang.*;
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int fNum = friends.length;
        int[][] data = new int[fNum][fNum]; //1대1로 주고받은 선물 정보 배열
        int[] stats = new int[fNum]; //선물지수 배열
        int[] result = new int[fNum]; //이번달에 받을 총 선물 개수 배열
        
        //data 배열 만들기
        for(int i=0; i<gifts.length; i++){
            StringTokenizer st = new StringTokenizer(gifts[i]); //주고 받는 사람 이름 자르기
            String give = st.nextToken(); //주는사람
            String get = st.nextToken(); //받는사람
            int giveIdx = -1;
            int getIdx = -1;
            for(int j=0; j<fNum; j++){
                if(friends[j].equals(give)){
                    giveIdx = j; //주는사람 인덱스 찾기
                }
                if(friends[j].equals(get)){
                    getIdx = j; //받는사람 인덱스 찾기
                }
            }
            data[giveIdx][getIdx]++; //data 배열에 추가
        }
        
        //stats배열 만들기
        for(int i=0; i<fNum; i++){
            int giveSum = 0; //i의 준 선물 수
            int getSum = 0; //i의 받은 선물 수
            for(int j=0; j<fNum; j++){
                giveSum += data[i][j];
                getSum += data[j][i];
            }
            stats[i]=giveSum-getSum; //i의 선물지수 stats에 저장
        }
        
        //result배열 만들기
        for(int i=0; i<fNum-1; i++){
            for(int j=i+1; j<fNum; j++){
                if(data[i][j]!=data[j][i]){ //i와 j가 주고받은 선물수가 다를때
                    if(data[i][j]>data[j][i]){ //i가 더 많이 줬으면
                        result[i]++; //이번에 i가 받기
                    }else{
                        result[j]++; //아니면 j가 받기
                    }
                }else{ //i와 j가 주고받은 선물수가 같을때
                    if(stats[i]>stats[j]){ //선물지수가 i가 높으면
                        result[i]++; //이번에 i가 받기
                    }else if(stats[i]<stats[j]){ //j가 높으면
                        result[j]++; //j가 받기
                    }
                }
            }
        }
        //가장많은 선물수 구하기
        for(int i=0; i<fNum; i++){
            answer = Math.max(answer,result[i]);
        }
        return answer;
    }
}