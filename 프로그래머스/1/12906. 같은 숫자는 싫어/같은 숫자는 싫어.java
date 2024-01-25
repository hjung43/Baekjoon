import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] input = arr; //인풋 담을 배열
        
        Stack<Integer>stack = new Stack<>(); //연속적으로 나타나느 수 제거하고 저장할 스택
        
        //연속하는 수 제거하기
        for(int i=0; i<input.length; i++){
            //만약 i가 0이라면
            if(i==0){
                stack.add(input[i]); //무조건 stack에 추가
            }else{ //아니라면
                //스택에 마지막에 저장한 수와 다음 저장할 수가 다를때
                if(stack.peek()!=input[i]){
                    stack.add(input[i]); //스택에 추가
                }
            }
        }
        
        int total = stack.size(); //총 스택 길이 저장
        int[] answer = new int[total]; //정답 저장할 배열
        //정답 배열에 스택 옯기기
        for(int i=1; i<=total; i++){
            answer[total-i]=stack.pop();
        }
        //정답 배열 출력
        // System.out.println(Arrays.toString(answer));

        return answer; //정답리턴
    }
}