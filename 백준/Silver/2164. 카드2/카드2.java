import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //카드개수 입력받기
		Queue<Integer>queue = new LinkedList<>(); //카드 담을 큐 생성
		//큐에 카드 넣기
		for(int i=1; i<=n; i++) { //1~n까지
			queue.add(i);
		}
		int k = 1; //카드를 버릴지 뒤로뺄지 정하는 숫자(홀수면 버리고 짝수면 뒤로뺀다)
		//큐에 숫자가 하나 남을때 까지 반복하기
		while(queue.size()>1) {
			if(k%2 == 1)  //k가 홀수일때
				queue.poll(); //제일 앞에 있는 카드 버리기
			else  //k가 짝수일때
				queue.add(queue.poll()); //제일 앞에 있는 카드 뒤로 보내기
			k++; //카드를 하나씩 처리할때 마다 k증가
		}
		//결과 출력하기
		System.out.println(queue.poll());
	}
}