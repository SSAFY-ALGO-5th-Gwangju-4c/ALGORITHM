import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj1620 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> idx = new HashMap<>();
		String[] names = new String[N+1];
		for(int i = 1; i <= N; i++) {
			String name = br.readLine();
			idx.put(name, i);
			names[i] = name;
		}
		
		for(int i = 0; i < M; i++) {
			String q = br.readLine();
			//숫자면
			if(q.charAt(0) >= '0' && q.charAt(0) <= '9') {
				int qIdx = Integer.parseInt(q);
				System.out.println(names[qIdx]);
			}
			//이름이면
			else {
				System.out.println(idx.get(q));
			}
		}
	}

}
