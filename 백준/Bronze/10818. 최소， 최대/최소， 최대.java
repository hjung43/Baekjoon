import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		int n = sc.nextInt();
	
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		int [] nums = new int[n];
		for(int i = 0; i <n; i++) {
			nums[i] = sc.nextInt();
		}
		for(int i = 0; i <n; i++) {
			if(nums[i]>=max) {
				max = nums[i];
			}
			if(nums[i]<=min) {
				min = nums[i];
			}
		}
		System.out.print(min+" "+max);
	}
}