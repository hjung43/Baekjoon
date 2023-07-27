import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		int num = sc.nextInt();
		int sum = 0;
			
		for(int i = 1; i<=num; i++) {
			int price = sc.nextInt();
			int n = sc.nextInt();
			sum += (price*n);
		}
		if (sum == total)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}