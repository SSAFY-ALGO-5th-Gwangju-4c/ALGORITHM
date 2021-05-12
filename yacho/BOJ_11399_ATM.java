package BOJ;

import java.util.Scanner;
import java.util.Arrays;
 
public class BOJ_11399_ATM {
 
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		
		// ���� 
		Arrays.sort(arr);
 
 
		int prev = 0;	// ���������� ���ð� ������ 
		int sum = 0;	// ����� ���ð� ���� 
				
		for(int i = 0; i < N; i++) {	
			// ���������� ���ð��� ���� ����� �ɸ��� �ð��� �����ش�.
			sum += prev + arr[i];
		    
			// ���������� �����տ� ���� �ɸ��� �ð��� �����ش�.
			prev += arr[i];
		}
		System.out.println(sum);
	}
}