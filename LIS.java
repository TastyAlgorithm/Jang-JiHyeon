
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LIS {
	static ArrayList<Integer> array = new ArrayList<Integer>();
	static int n;
	private static int[] cache = new int[101];
	private static int[] S = new int[100];
	
	public static int answer(int start) {
		int ret = cache[start];
		
		if(ret != -1)
			return ret;
		
		ret = 1;
		
		for (int next = start+1; next< n; ++next)
			if(S[start] < S[start])
				ret = Math.max(ret, answer(next) + 1);
				
		return ret;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        
        for(int i =0; i<C; i++){
        	int ans = 0;
        	
        	Arrays.fill(cache, -1);
        	
            int N = sc.nextInt();
            
            for(int j=0; j<N; j++)
            	array.add(sc.nextInt());
            
            for(int j=0; j<N-1; j++)
            	ans = Math.max(ans, answer(i));
            
            System.out.println(ans);
        }
	}
}
