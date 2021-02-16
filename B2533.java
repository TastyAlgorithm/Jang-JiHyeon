
import java.util.LinkedList;
import java.util.Scanner;

public class B2533 {
	static int N;
	static int[] visit;
	static int[][] dp;
	static LinkedList<Integer>[] list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		visit = new int[N + 1];
		dp = new int[N + 1][2];
		list = new LinkedList[N + 1];
		
		for (int i = 1; i <= N; i++)
			list[i] = new LinkedList<>();
		
		for (int i = 0; i < N - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		
		int start = 1;
		dfs(start);
		System.out.println(Math.min(dp[start][0], dp[start][1]));
	}
	
	public static void dfs(int index) {
		visit[index] = 1;
		dp[index][0] = 0;
		dp[index][1] = 1;
		
		LinkedList<Integer> item = list[index];
		
		for (int to : item) {
			if (visit[to] == 0) {
				dfs(to);
				dp[index][0] += dp[to][1];
				dp[index][1] += Math.min(dp[to][0], dp[to][1]);
			}
		}
	}
}


