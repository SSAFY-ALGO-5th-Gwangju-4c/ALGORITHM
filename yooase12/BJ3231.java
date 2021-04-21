import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj3231 {

	static class loc implements Comparable<loc>{
		int num, idx;

		public loc(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}

		@Override
		public int compareTo(loc o) {
			return this.num - o.num;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<loc> pq = new PriorityQueue<>(); //순서대로 꺼내기 위해 우선순위 큐
		
		//입력
		//O(N log N) 
		for(int i = 1; i <= n; i++) {
			int num = Integer.parseInt(br.readLine());
			pq.offer(new loc(num, i));
		}
		loc first = pq.poll(); //1번 꺼내기
		int lastIdx = first.idx;
		int ans = 0;
		//O(N)
		while(!pq.isEmpty()) {
			loc tp = pq.poll();//2번 ~ N번 꺼내기
			int tIdx = tp.idx;
			
			if(lastIdx > tIdx) { //현재 수가 이전에 꺼낸 수보다 앞에 있는 경우
				ans++;
			}
			lastIdx = tIdx;
		}
		System.out.println(ans);
	}

}
