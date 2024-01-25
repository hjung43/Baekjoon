class Solution {
    public int solution(int[] numbers) {
        int[] arr = new int[10];
        int answer = 0;
        for(int j=0; j<numbers.length; j++){
            arr[numbers[j]] = 1;
        }
        
        for(int i=0; i<10; i++){
            if(arr[i]==0){
                answer = answer + i;
            }
        }

        return answer;
    }
}