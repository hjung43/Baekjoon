import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트 케이스 10번 반복하기
		for (int t = 0; t < 10; t++) {
			Queue<Integer> queue = new LinkedList<>(); //큐 생성
			int T = sc.nextInt(); //테스트 케이스 번호 받기
			//큐에 숫자 8개 입력
			for (int i = 0; i < 8; i++) {
				queue.add(sc.nextInt());
			}
			//사이클 반복해서 돌리기
			loop1: while (true) {
				int cnt = 1; //감소할 수
				//한 사이클 돌때마다 반복
				for (int i = 0; i < 5; i++) { //한 사이클에 5까지 감소하니까 5번 반복
					if (queue.peek() - cnt > 0) {  //첫번째 숫자에 감소할 수를 뺐을 때 0보다 크면
						queue.add(queue.poll() - cnt++); //첫번째 숫자에 감소할 수 빼고 제일뒤로 넣기
					} else {  //첫번째 숫자에 감소할 수를 뺐을때 0보다 작거나 같으면
						queue.poll(); //첫번째 숫자 빼기
						queue.add(0); //마지막에 숫자 0넣기
						break loop1; //전체 사이클 반복 종료
					}
				}
			}
			//결과 출력하기
			System.out.print("#" + T + " ");
			for (int i : queue) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}