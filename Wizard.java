package Wizard;
import java.util.*;
public class Wizard {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		HashMap <String,String> hm=new HashMap();
		String base;
		String B;
		String result[]=new String[10];
		for(int i=0;i<10;i++) {
			int N=in.nextInt();
			int M=in.nextInt();
			for(int j=0;j<4;j++) {
				String a=in.next();
				String b=in.next();
				hm.put(a, b);
			}
			base=in.next();
			B=in.next();
			result[i]=Solve(N,M,hm,base);
		}
		for(int i=0;i<10;i++) {		
			System.out.println(result[i]);
		}
	}

	public static String Solve(int n, int m, HashMap<String, String> hm, String base) {
		String key; 
		String nextLevel="";
		for(int i=0;i<base.length();i++) {
			if(i==0) {
				key=base.charAt(base.length()-1)+""+base.charAt(1)+"";
			}
			else if(i==base.length()-1) {
				key=base.charAt(base.length()-2)+""+base.charAt(0)+"";
			}
			else
			{
				key=base.charAt(i-1)+""+base.charAt(i+1)+"";
			}
			nextLevel=nextLevel+hm.get(key);
		}
		if(m==2)
			return nextLevel;
		return Solve(n,m-1,hm,nextLevel);
		
	}

}
