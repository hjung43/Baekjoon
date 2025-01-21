import java.util.*;
import java.lang.*;
import java.io.*;
class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();//문자열 담을 Stringbuilder
        //물(인덱스0)빼고 음식 종류 수 만큼 탐색
        for(int i=1; i<food.length; i++){
            int cntFood = food[i]/2;
            //해당음식의 개수/2 한번 만큼 한 왼쪽 선수가 먹을 수 있도록 sb에 넣기
            for(int j=0; j<cntFood; j++){
                sb.append(i);
            }
        }
        sb.append(0); //가운데 물 추가
        //왼쪽 선수가 먹은 만큼 오른쪽 선수 먹을 음식 추가
        for(int i=sb.length()-2; i>=0; i--){
            sb.append(sb.charAt(i));
        }
        String answer = sb.toString(); //자료형 문자열로 바꾸기
        return answer;
    }
}