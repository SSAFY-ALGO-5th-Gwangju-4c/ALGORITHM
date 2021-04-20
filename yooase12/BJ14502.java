import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14502 {

	static int N, M, ans = 0;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Empty> empty;
	static ArrayList<Virus> virus;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Empty {
		int r, c;
		
		public Empty(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static class Virus{
		int r, c;

		public Virus(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		empty = new ArrayList<>();
		virus = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) { //벽을 세울 수 있다면.
					empty.add(new Empty(i,j));
				}
				else if(map[i][j] == 2) {
					virus.add(new Virus(i,j));
				}
			}
		}
		
		Combination(0, 0);
		System.out.println(ans);
	}
	
	static void Combination(int start, int cnt) {
		if(cnt == 3) { //벽 다세움.
			int[][] temp_map = clone(map);
			
			//바이러스 퍼트리기
			Queue<Virus> q = new LinkedList<>();
			for(int i = 0; i < virus.size(); i++)
				q.offer(virus.get(i));
			
			while(!q.isEmpty()) {
				Virus cur = q.poll();
				int cr = cur.r;
				int cc = cur.c;
				for(int i = 0; i < 4; i++) {
					int nr = cr + dx[i];
					int nc = cc + dy[i];
					if(nr >= 0 && nr < N && nc >= 0 && nc < M && temp_map[nr][nc] == 0) {
						q.offer(new Virus(nr, nc));
						temp_map[nr][nc] = 2;
					}
				}
			}
			
			//빈공간 카운트
			ans = Math.max(ans, count(temp_map));
		}
		else { //벽 세우는 중
			for(int i = start; i < empty.size(); i++) {
				map[empty.get(i).r][empty.get(i).c] = 1;//벽 세우기.
				Combination(i+1, cnt+1);
				map[empty.get(i).r][empty.get(i).c] = 0;//벽 허물기.
			}
		}
	}
	static int[][] clone(int[][] map) {
		int [][] temp_map = new int[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				temp_map[i][j] = map[i][j];
		return temp_map;
	}
	
	static int count(int[][] map) {
		int tp = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(map[i][j] == 0) tp++;
		return tp;
	}

}