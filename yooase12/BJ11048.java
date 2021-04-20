import java.util.Scanner;

public class BJ11048 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N+1][M+1];
		int[][] result = new int[N+1][M+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++)
				arr[i][j] = sc.nextInt();
		}
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				result[i][j] = Math.max(result[i-1][j] , 
						Math.max(result[i-1][j-1], result[i][j-1])) + arr[i][j];
			}
		}
		System.out.println(result[N][M]);
		
	}
}
