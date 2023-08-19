import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer>queue = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			queue.add(i);
		}
		int k = 1;
		while(queue.size()>1) {
			if(k%2 == 1) 
				queue.poll();
			else 
				queue.add(queue.poll());
			k++;
		}
		System.out.println(queue.poll());
	}
}