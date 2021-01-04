import java.util.Scanner;
import java.util.ArrayList;

public class JOSEPHUS {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[][] result;
		int killIndex = 0;
		
		int C = scanner.nextInt();
		result = new int[C][2];
		
		for (int i=0; i<C; i++) {
		
			int N = scanner.nextInt();
			int K = scanner.nextInt();
			
			for(int j=1; j<=N; j++) {
				list.add(j);
			}

			for(int k=0; k<N-2; k++) {
				int size = list.size();
				int n = 0;
				
				if(size > 2) {
					if(killIndex >= size) {
						killIndex %= list.size();
					}
					list.remove(killIndex);
					killIndex += K-1;
				}
			}
			
			int m1 = list.get(0);
			int m2 = list.get(1);
			
			result[i][0] = m1;
			result[i][1] = m2;
 		}
		
		for(int i=0; i<C; i++) {
			System.out.println(result[i][0] + " " + result[i][1]);
		}
	}
}
