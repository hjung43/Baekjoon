import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length]; //정답배열
        int[] kList = new int[k]; //명예의 전당 배열
        answer[0] = score[0]; //첫번째 최소발표점수는 점수가 하나밖에 없기 때문에 무조건 score[0]
        int kScore = 0;
        if(k > score.length){
            kScore=score.length;
        }else{
            kScore=k;
        }
        
        //k일 만큼의 일차별 명예의 전당점수 계산
        for(int l=1; l<kScore; l++){
            //i+1일차의 발표점수 내림차순 정리
            for(int i=0; i<l; i++){
                for(int j=i+1; j<l+1; j++){
                    if(score[i]<score[j]){
                        int t= score[i];
                        score[i]=score[j];
                        score[j]=t;
                    }
                    //정리한 점수 순위 명예의전당 배열에 옮기기
                    kList[j] = score[j]; 
                    kList[i] = score[i];
                }
            }
            answer[l]=score[l]; //정답배열에 정리한 점수중 가장 작은 점수 옮기기
        }
        // if(k!=score.length){
            //k일차부터 마지막날 까지 명예의전당 점수 계산
            for(int i=k; i<score.length; i++){
                //현재 명예의전당 점수들과 i일차의 점수 비교
                for(int j=0; j<k; j++){
                    if(kList[j]<score[i]){ //명예의전당에 있는 j번째 점수보다 i일차 점수가 더 크면
                        //j번째 부터 밑으로 한칸씩 점수 옮기기
                        for(int l=k-1; l>j; l--){
                            kList[l]=kList[l-1];
                        }
                        kList[j]=score[i]; //j번째에 i일차 점수 넣기
                        break; //내림차순이라 다음 점수들도 무조건 i일차 점수보다 작을테니까 멈추기
                    }
                }
                answer[i]=kList[k-1]; //i일차 까지 명예의전당 점수정리 후 가장 작은 점수 정답배열에 넣기
            }
        // }      
        return answer;
    }
}