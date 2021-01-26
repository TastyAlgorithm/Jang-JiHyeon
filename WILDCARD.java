
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
 
public class WILDCARD {
	
	static char[] W, S;
    static ArrayList<String> SArray = new ArrayList<String>();
    static int[][] cache = new int[101][101];
    
    public static int matchMemoized(int w, int s) {
    	int ret = cache[w][s];
    	
    	if(ret != -1)
    		return ret;
    	
    	while(s < S.length && w < W.length && 
    			(W[w] == '?' || W[w] == S[s])) {
    		++w;
    		++s;
    	}
    	
    	if(w == W.length) {
            return ret = (s == S.length)? 1 : 0;
    	}

    	if(W[w] == '*') 
    		for(int skip = 0; skip+s <= S.length; ++skip)
    			if(matchMemoized(w+1, s+skip) == 1) {
    				return ret = 1;
    			}
    	
    	return ret = 0;
    }
    
    public static void answer() {
        ArrayList<String> result = new ArrayList<String>();
        for(int i=0; i<SArray.size(); i++){
            
        	for(int[] arr : cache)
                Arrays.fill(arr, -1);
        	
            String temp = SArray.get(i);
            S = temp.toCharArray();
            if(matchMemoized(0,0) == 1) {
            	result.add(temp);
            }
        }
        
        Collections.sort(result);
        for(int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        
        for(int i =0; i<C; i++){
            
            String wc = sc.next();
            int file = sc.nextInt();
            
            W = wc.toCharArray();
            
            for(int j=0; j<file; j++)
            	SArray.add(sc.next());
            
            answer();
        }
    }
}
