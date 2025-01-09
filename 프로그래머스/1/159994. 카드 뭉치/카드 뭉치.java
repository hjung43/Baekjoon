class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = ""; //정답 담을 변수
        int c1 = 0; //첫번째 카드뭉치 현재 인덱스
        int c2 = 0; //두번째 카드뭉치 현재 인덱스
        boolean isMake = true; //만들 수 있는지 확인할 변수
        
        //원하는 단어 배열 만큼 반복
        for(int i=0; i<goal.length; i++){
            //첫번째 카드뭉치에서 인덱스가 배열을 넘지 않고 현재 필요한 단어를 가리키면
            if(c1<cards1.length && cards1[c1].equals(goal[i])){
                c1++; //다음 인덱스로 넘어가기
            //두번째 카드뭉치에서 인덱스가 배열을 넘지 않고 현재 필요한 단어를 가리키면
            }else if(c2<cards2.length && cards2[c2].equals(goal[i])){
                c2++; //다음 인덱스로 넘어가기
            }else{ //원하는 단어가 현재 인덱스에 없으면
                isMake = false; //문장을 만들 수 없음
                break;
            }
        }
        //문장 만들수 있는지 확인 후 리턴
        if(isMake){
            answer = "Yes";
        }else{
            answer = "No";
        }
        
        return answer;
    }
}