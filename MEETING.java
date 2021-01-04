import java.util.ArrayList;
import java.util.Scanner;

public class MEETING {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> mlist = new ArrayList<Integer>();
		ArrayList<Integer> glist = new ArrayList<Integer>();
		int r;
		int T = scanner.nextInt();
		int[] result = new int[T];
		
		for (int i=0; i<T; i++) {
			r = 0;
			mlist.clear();
			glist.clear();
			
			int N = scanner.nextInt();
			
			for(int j=0; j<N; j++) {
				mlist.add(scanner.nextInt());
			}
			
			for(int j=0; j<N; j++) {
				glist.add(scanner.nextInt());
			}

			for(int j=0; j<N; j++) {
				r += Math.abs(mlist.get(j)-glist.get(j));
			}
			
			result[i] = r;
 		}
		
		for(int l=0; l<T; l++) {
			System.out.println(result[l]);
		}
	}

}
