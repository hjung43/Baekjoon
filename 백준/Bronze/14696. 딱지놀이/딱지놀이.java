import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 번호 입력받기

		// 테스트케이스만큼 반복
		for (int t = 0; t < T; t++) {
			int[] acnt = new int[5];
			int[] bcnt = new int[5];
			for (int i = 0; i < 2; i++) {
				int n = sc.nextInt();
				int[] nums = new int[n];
				for (int j = 0; j < n; j++) {
					nums[j] = sc.nextInt();
					if (i == 0)
						acnt[nums[j]]++;
					else
						bcnt[nums[j]]++;
				}
			}
			if (acnt[4] > bcnt[4]) {
				System.out.println("A");
			} else if (acnt[4] == bcnt[4]) {
				if (acnt[3] > bcnt[3])
					System.out.println("A");
				else if (acnt[3] == bcnt[3]) {
					if (acnt[2] > bcnt[2])
						System.out.println("A");
					else if (acnt[2] == bcnt[2]) {
						if (acnt[1] > bcnt[1])
							System.out.println("A");
						else if (acnt[1] == bcnt[1])
							System.out.println("D");
						else
							System.out.println("B");
					}else
						System.out.println("B");
				}else
					System.out.println("B");
			} else {
				System.out.println("B");
			}
		
		}
	}
}