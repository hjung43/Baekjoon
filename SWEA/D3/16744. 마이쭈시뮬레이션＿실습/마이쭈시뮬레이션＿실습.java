import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Solution {
	
	static class Person{
		int num; //사람의 번호
		int cnt; //사람마다 마이쮸 개수
		public Person(int num) {
			this.num = num;
			this.cnt = 1;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		//테스트 케이스 T만큼 반복하기
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt(); //마이쮸 총 개수
			int pNum = 1; //사람 번호
			Queue<Person> queue = new LinkedList<>(); //큐 생성
			queue.add(new Person(pNum++)); //큐에 1번 Person 추가하기
			//마이쮸가 0개가 될때까지 반복
			while(n>0){
				Person p = queue.poll(); //큐에 있는 첫번째 Person을 빼기
				n -= p.cnt; //뺀 Person이 가져야 하는 마이쮸만큼을 전체 마이쮸 개수에서 빼기
				if(n>0) {
					p.cnt++; //새로 줄 서면서 받아야하는 마이쮸 개수 추가
					queue.add(p); //새로 줄서기(큐에 다시 추가)
					queue.add(new Person(pNum++)); //새로운 사람 추가
				}else {  //마이쮸가 0개가 되면
					System.out.printf("#%d %d\n",t,p.num); //마지막으로 마이쮸를 받아간 사람 출력
				}
			}			
		}
	}
}