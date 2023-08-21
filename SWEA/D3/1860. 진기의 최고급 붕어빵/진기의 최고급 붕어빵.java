import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수 받기
		// 테스트 케이스 수 만큼 반복
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt(); // 예약자 수
			int m = sc.nextInt(); // 붕어빵을 만드는데 걸리는 시간
			int k = sc.nextInt(); // 한번 만들때 만들어지는 붕어빵 수
			// 사람이 도착하는 시간 담을 우선순위 큐 생성
			PriorityQueue<Integer> pq = new PriorityQueue<>(); // 숫자를 저장하면 오름차순으로 정렬해줌
			// 우선순위 큐에 사람이 도착하는 시간 담기
			for (int i = 1; i < n + 1; i++) {
				pq.add(sc.nextInt());
			}
			String result = "Possible"; // 결과값 담을 변수
			int i = pq.peek(); // 초 담을 변수 (사람이 도착하는 시간마다 확인)
			int take = 0; // pq.peek()때 오는 사람 앞에서 가져간 붕어빵 개수
			// 큐가 빌때까지 반복
			while (!pq.isEmpty()) {
				if (i / m * k - take > 0) { // pq.peek()초일때 붕어빵 개수가 0보다 크면(take는 앞사람이 가져간 붕어빵 개수)
					take++; // 가져간 붕어빵 개수 1추가
					pq.poll(); //가장 먼저 온 사람 빼기
				} else { // pq.peek()초일때 붕어빵 개수가 0보다 작거나 같으면 (가져갈 붕어빵이 없으면)
					result = "Impossible"; // 결과값 바꾸기
					break;
				}
				//마지막으로 poll하고나선 큐가 빌 수 있기 때문에
				if (!pq.isEmpty()) //비지 않았을때만
					i = pq.peek(); //i를 peek으로 초기화
			}
			//결과 출력하기
			System.out.println("#" + t + " " + result);
			
		}
	}
}