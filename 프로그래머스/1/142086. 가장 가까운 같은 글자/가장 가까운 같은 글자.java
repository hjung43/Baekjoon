class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()]; //문자열 크기 만큼 정답배열 만들기
        answer[0] = -1; //제일 첫번째 문자는 앞에 글자가 없으니까 -1
        //문자열 뒤에서부터 두글자씩 탐색
        for(int i=s.length()-1; i>=1; i--){
            for(int j=i-1; j>=0; j--){

                if(s.charAt(i)==s.charAt(j)){ //두 글자가 같으면
                    answer[i] = i-j; //인덱스끼리 빼서 넣기
                    break;
                }
            }
            //break없이 for문 다 돌면
            if(answer[i]==0){
                answer[i] = -1; //-1넣기
            }
        }
        
        return answer;
    }
}