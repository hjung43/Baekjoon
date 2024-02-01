import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        
        boolean findMin = false;

        if(arr.length-1==0){
            int[] answer = {-1};
            return answer;
        }
        int idx = 0;
        int[] answer = new int[arr.length-1];
        loop: for(int i=0; i<arr.length; i++){
            boolean isBig = false;
            if(!findMin){
                for(int j=i+1; j<arr.length; j++){
                    if(arr[i]>arr[j]){
                        isBig=true;
                    }
                }
                if(isBig){
                    answer[idx++] = arr[i];
                }else{
                    findMin = true;
                }
            }else{
                answer[idx++] = arr[i];
            }
        }



    
        return answer;
    }
}