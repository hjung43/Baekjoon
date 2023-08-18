import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트 케이스 T만큼 반복하기
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt(); // 총 카드 개수
			int half = n / 2; //총 카드를 반으로 나눈 값
			if (n % 2 == 1) //n이 홀수이면 +1을 해준다
				half += 1;
			//카드를 반으로 나눠서 큐에 각각 넣기
			Queue<String> queue1 = new LinkedList<>(); // 큐 생성
			Queue<String> queue2 = new LinkedList<>(); // 큐 생성
			//앞쪽 반 큐에 카드 이름 넣기
			for (int i = 0; i < half; i++) {
				queue1.add(sc.next());
			}
			//나머지 반 다른큐에 카드 이름 넣기
			for (int i = 0; i < n / 2; i++) {
				queue2.add(sc.next());
			}
			//카드 섞어서 출력
			System.out.printf("#%d ",t);
			//더 큰 카드수 만큼 반복
			for (int i = 0; i < half; i++) {
				if (!queue1.isEmpty() && !queue2.isEmpty()) { //큐 두개다 비지 않았으면
					System.out.print(queue1.poll()+" "); //차례로 1에서 poll
					System.out.print(queue2.poll()+" "); //2에서 poll
				} else if(queue2.isEmpty() && !queue1.isEmpty()) { //2만 비었으면(n이 홀수인 경우)
					System.out.print(queue1.poll()+" "); //1에서만 poll
				}else { //큐 두개 다 비었으면
					break; //출력중지
				}
			}System.out.println(); //테스트 케이스 마다 줄바꿈
		}
	}
}