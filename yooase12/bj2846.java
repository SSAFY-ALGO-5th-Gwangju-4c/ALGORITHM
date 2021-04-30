import java.util.Scanner;

public class bj2846 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int ans = 0;
		int min = 1001; //최대 1000이므로
		int prev = 1001;//전에 입력된 값
		for(int i = 0; i < N; i++) {
			int current = sc.nextInt();
			//높은 곳에서 낮은곳으로 가면 가장 낮은 곳하고 높은 곳 차이 중 가장 큰 값 저장
			if(current <= prev) {
				ans = Math.max(ans, prev-min);
				min = current;
			}
			prev = current;
		}
		
		//마지막 결과값 반영
		ans = Math.max(ans, prev - min);
		
		System.out.println(ans);
	}

}
