import java.util.Scanner;
 
public class JUMPGAME {
    
    static int n;
    static int board [][] = new int[100][100];
    static int cache [][] = new int[100][100];
    static int ret = 0;
    
    public static int jump(int x, int y){
        if(x >= n || y >= n) return 0; 
        
        if(x==n-1 && y==n-1) return 1;
        
        ret = cache[x][y];
        if(ret != -1) return ret;
        
        int jumpSize = board[x][y];
        return ret = jump(x+jumpSize, y) | jump(x, y+jumpSize);
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        
        for(int i = 0; i<C; i++){
            n = sc.nextInt();
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                	cache[j][k] = -1;
                	board[j][k] = sc.nextInt();
                }
            }
            int res = jump(0,0);
            System.out.println(res!=0? "YES":"NO");
        }
    }
}
