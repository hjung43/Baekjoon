import java.lang.*;
import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0; //정답 변수
        int boxMin = k; //박스의 최솟값 사과의 최대점수로 초기화
        int cntA = 0; //박스에 현재 사과 몇개 담겼는지 확인할 개수
        Arrays.sort(score); //사과 점수 오름차순으로 정리
        //사과 마지막 인덱스부터 (제일 큰 사과부터)탐색
        for(int i=score.length-1; i>=0; i--){
            //이전의 가장 작은 사과점수와 현재 사과점수 비교해서 더 작은거 저장
            boxMin = Math.min(boxMin, score[i]); 
            cntA++; //상자안에 사과개수 추가
            if(cntA==m){ //상자안에 사과가 꽉차면
                answer += boxMin*m; //가장작은 사과점수 * 상자안의 사과개수로 사과점수 answer에 더하기
                cntA = 0; //상자안의 사과개수 0개로 초기화
                boxMin = k; //상자 안의 최소 사과점수 사과의 최대점수로 초기화
            }
        }
        return answer;
    }
}