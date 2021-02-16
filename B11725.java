import java.util.ArrayList;
import java.util.Scanner;

public class B11725 {
    static int n ;
    static ArrayList<Integer>[] list = new ArrayList[n+1];
    static int[] p = new int[n+1];
    static boolean[] check = new boolean[n+1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        
        for (int j = 1; j <n ; j++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
            list[b].add(a);
        }

        for (int k = 1; k <=n ; k++) {
            if(!check[k]){
                dfs(k);
            }
        }
        
        for (int i = 2; i <=n ; i++) {
            System.out.println(p[i]);
        }
    }

    private static void dfs(int v){
        if(check[v]){
            return;
        }
        check[v] = true;
        for (int vv: list[v]) {
            if(!check[vv]){
                p[vv] = v;
                dfs(vv);
            }

        }

    }

}
