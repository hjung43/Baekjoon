import java.lang.*;
import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length]; //targets의 길이 만큼의 정답배열 만들기
        
        //타겟 배열 만큼 반복
        for(int i =0; i<targets.length; i++){
            for(int j=0; j<targets[i].length(); j++){ //타겟i번째의 문자열 글자수만큼 반복
                char nowTarget = targets[i].charAt(j); //타겟i번째의 j번째 글자
                int minIdx = 100; //j번째 글자가 있는 인덱스
                //keymap 길이 만큼반복 
                for(int k=0; k<keymap.length; k++){
                    //keymap의 k번째 문자열 글자수만큼 반복
                    for(int l=0; l<keymap[k].length(); l++){
                        //k번째문자열의 l번째 글자가 nowTarget과 같으면
                        if(keymap[k].charAt(l) == nowTarget){
                            minIdx = Math.min(minIdx, l); //minIdx나 현재 idx중에 더 작은 수 저장
                            break; //같은 글자 찾았으니 멈추기
                        }
                    }
                }
                if(minIdx<100){ //keymap에서 글자를 찾았으면
                    answer[i] += minIdx+1; //가장 작은 idx+1을 answer[i]에 더하기
                }else{ //글자를 못찾았을때(문자열을 완성하지 못할때)
                    answer[i]=-1; //-1값을 저장
                    break; //다음 글자 찾지 않고 다음 문자열로 넘어가기
                }
            }
        }
        
        
        
        return answer;
    }
}