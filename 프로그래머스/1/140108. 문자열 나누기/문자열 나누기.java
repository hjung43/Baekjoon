class Solution {
    public int solution(String s) {
        int answer = 0; //정답 저장할 변수
        char nChar = 0; //현재 문자열의 첫번째 문자 저장할 변수
        int sChar = 0; //같은 문자 개수
        int dChar = 0; //다른 문자 개수
        
        //문자열 크기만큼 반복
        for(int i=0; i<s.length(); i++){
            //지금 문자가 문자열의 첫번째 문자일 때
            if(nChar == 0){
                nChar = s.charAt(i);
            }
            //지금 문자가 첫번째 문자랑 같을때 
            if(s.charAt(i)==nChar){
                sChar++; //같은문자개수 추가
            }else{ //다를때
                dChar++; //다른 문자 개수 추가
            }
            //같은문자와 다른문자의 개수가 같거나 현재 문자열의 마지막 문자일때
            if(sChar == dChar || i==s.length()-1){
                answer++; //문자열 자르기(개수 추가)
                sChar = dChar = nChar = 0;  //같은,다른 문자개수 초기화, 첫번째 문자 초기화
            }
        }
        
        return answer;
    }
}