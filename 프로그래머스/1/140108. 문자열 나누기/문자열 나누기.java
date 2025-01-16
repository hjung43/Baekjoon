class Solution {
    public int solution(String s) {
        int answer = 0;
        boolean st = true;
        char nChar = 'a'; 
        int sChar = 0;
        int dChar = 0;
        for(int i=0; i<s.length(); i++){
            if(st){
                nChar = s.charAt(i);
            }
            if(s.charAt(i)==nChar){
                sChar++;
            }else{
                dChar++;
            }
            if(sChar == dChar || i==s.length()-1){
                answer++;
                st = true;
            }else{
                st = false;
            }
        }
        
        return answer;
    }
}