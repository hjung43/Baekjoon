import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int min = Integer.MAX_VALUE;
		
		int [] length = {Math.abs(x-w),x,Math.abs(y-h),y};
		 
		for(int i: length) {
			if(i<min)
				min=i;
		}
		
		System.out.println(min);

	}

}