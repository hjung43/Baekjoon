import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        
        int carpet = brown + yellow;
        int[] answer = new int[2];
        

        
        int i=3;
        while(carpet/i>=3){
            if(carpet%i==0 && (i-2)*(carpet/i-2)==yellow){
                
                    answer[1]=i;
                    answer[0]=carpet/i;
                    break;
               
            }else{
                i++;
            }
        }

        return answer;
    }
}