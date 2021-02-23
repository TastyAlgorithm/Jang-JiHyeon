import java.util.*;

//바이러스

public class B2606 {
	static boolean[] check;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();

		check = new boolean[n + 1]; 
		list = (ArrayList<Integer>[]) new ArrayList[n + 1];

		for (int i = 1; i <= n; i++)
			list[i] = new ArrayList<Integer>();

		for (int i = 1; i <= l; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			list[u].add(v);
			list[v].add(u);
		}

		dfs(1);

        int count = 0;

        for(int i=2; i<=check.length-1; i++){
        	if(check[i]) count++;
        }
        System.out.println(count);
	}
	
	private static void dfs(int v){
        if(check[v]){
            return;
        }
        check[v] = true;
        for (int vv: list[v]) {
            if(!check[vv]){
                dfs(vv);
            }
        }
	}
}
