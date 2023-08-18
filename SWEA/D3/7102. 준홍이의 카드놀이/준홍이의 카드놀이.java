import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트 케이스 수 입력
		// 테스트 케이스 T만큼 반복하기
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt(); //첫번째 카드세트 개수
			int m = sc.nextInt(); //두번째 카드세트 개수
			Queue<Integer> qn = new LinkedList<>(); //첫번째 카드세트 담을 큐
			Queue<Integer> qm = new LinkedList<>(); //두번째 카드세트 담을 큐
			int[] count = new int[n+m+1]; //두 카드의 합의 개수를 저장하는 카운트 배열
			int num = 1; //큐에 넣을 카드 번호
			//첫번째 카드세트 큐에 넣기
			for(int i=0; i<n; i++) {
				qn.add(num++);
			}
			num = 1; //큐에 넣을 카드 번호 1부터로 초기화
			//두번째 카드세트 다른 큐에 넣기
			for(int i=0; i<m; i++) {
				qm.add(num++);
			}
			//첫번째 카드와 두번째 카드의 합 구한 후 count배열로 개수세기
			for(int i=0; i<n; i++) {
				int qnNum = qn.poll(); //첫번째 카드 순서대로 뽑기
				for(int j=0; j<m; j++) {
					int qmNum = qm.poll(); //두번째 카드 순서대로 뽑기
					count[qnNum+qmNum]++; //두 카드의 합 구하기
					qm.add(qmNum); //두번째 카드 다시 젤 뒤로 넣기 (반복해서 첫번째 카드의 다음 카드와도 비교해아 하기 때문)
				}
			}
			int max=0; //카운트의 최대값 저장할 변수
			//카운트 배열에서 최댓값 찾기
			for(int i=0; i<n+m+1; i++) {
				if(count[i]>max) {
					max=count[i];
				}
			}
			//최댓값을 갖고 있는 인덱스 모두 출력
			System.out.printf("#%d ",t);
			for(int i=0; i<n+m+1; i++ ) {
				if(count[i]==max)
					System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}