import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BRACKETS2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int C = scanner.nextInt();
        String[] s = new String[C];
        String[] result = new String[C];
        ArrayList<String> list;
        ArrayList<String> open = new ArrayList<String>();
        
        int count = 0;
 
        for (int i=0; i<C; i++) {
        	s[i] = scanner.next();
           
        	list = new ArrayList<String>(Arrays.asList(s));
         
        	if(list.size()%2 == 0) {
        		for(i=0; i<list.size(); i++) {
        			if(list.get(i) == "(" || list.get(i) == "{" || list.get(i) == "[") {
        				open.add(list.get(i));
        			}
        		}
        		for(i=0; i<list.size(); i++) {
        			String f = open.get(open.size()-1);
        			if(list.get(i) == ")") {
        				if(f == "(") {
        					open.remove(open.size()-1);
        				} else {
        					result[i] = "NO";
        				}
        			}
        			else if(list.get(i) == "}") {
        				if(f == "{") {
        					open.remove(open.size()-1);
        				} else {
        					result[i] = "NO";
        				}
        			}
        			else if(list.get(i) == "]") {
        				if(f == "[") {
        					open.remove(open.size()-1);
        				} else {
        					result[i] = "NO";
        				}
        			}
               
        			if(open.size() == 0) {
        				result[i] = "YES";
        			}
        		}
        	} else {
        		result[i] = "NO";
        	}
        }

        for(int i=0; i<C; i++){
        	System.out.println(result[i]);
        }
	}
}
