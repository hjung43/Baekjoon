import java.util.Arrays;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        Arrays.sort(wallet);
        Arrays.sort(bill);
        while(wallet[0]<bill[0] || wallet[1]<bill[1]){
            bill[1] = bill[1]/2;
            answer ++;
            Arrays.sort(wallet);
            Arrays.sort(bill);
        }
        return answer;
    }
}