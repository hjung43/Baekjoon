class Solution {
    public long solution(int price, int money, int count) {
        long total = 0; //총 놀이기구의 이용 금액
        //한번 탈때마다 n배 해서 더하기
        for(int i=0; i<count; i++){
            total += price*(i+1);
        }
        //금액이 부족하지 않으면 0리턴
        if(money-total>=0){
            return 0;
        }
        return total-money;
        //return Math.max(total-money,0); 이렇게 하면 if문 필요없음
    }
}