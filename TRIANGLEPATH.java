import java.util.Scanner;

public class TRIANGLEPATH {
	
	static int n;
    static int triangle [][] = new int[100][100];
    static int cache [][] = new int[100][100];
    static int ret = 0;
    
	public static int path(int y, int x) {
		if(y == n-1) return triangle[y][x];
		
		ret = cache[y][x];
		if(ret != -1) return ret;
		
		return ret = Math.max(path(y+1, x),  path(y+1, x+1)) + triangle[y][x];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for(int i=0; i<C; ++i) {
			n = sc.nextInt();
			for(int j=1; j<=n; ++j) {
				for(int k=1; k<=j; ++k) {
					cache[j][k] = -1;
					triangle[j][k] = sc.nextInt();
				}
			}
			int res = path(0,0);
			System.out.println(res);
		}
	}
}

