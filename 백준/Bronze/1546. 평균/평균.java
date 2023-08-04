import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double m = 0;
		double sum =0;
		double[] score = new double[n];
		for(int i=0; i<n; i++) {
			score[i] = sc.nextInt();
		}
		for(double i : score) {
			if(i>m)
				m = i;
		}
		for(int i=0; i<n; i++) {
			score[i] = score[i]/m*100;
			sum += score[i];
		}
		System.out.println(sum/n);
	}
}