
public class LongestCommonSubsequence {

	public static int lcs(String s1,String s2){
		if(s1.length() ==0 || s2.length() == 0){
			return 0;
		}
		int count = 0;
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		
		if(s1.charAt(0) == s2.charAt(0)){
			count = 1+lcs(ros1,ros2);
		}else{
			int f1 = lcs(ros1,s2);
			int f2 = lcs(s1,ros2);
			
			count = Math.max(f1, f2);
		}
		return count;
	}
	public static int lcsIter(String s1,String s2){
		int strg[][] = new int[s1.length()+1][s2.length()+1];
		strg[s1.length()][s2.length()] =0;
		for(int i=s1.length() ; i>=0 ; i--){
			for(int j=s2.length() ; j>=0;j--){
				
				if(i == s1.length()){
					strg[i][j] =0;
					continue;
				}
				if(j == s2.length()){
					strg[i][j] = 0;
				continue;	
				}
				if(s1.charAt(i) == s2.charAt(j)){
					strg[i][j] = 1+strg[i+1][j+1];
				}else{
					strg[i][j] = Math.max(strg[i+1][j], strg[i][j+1]);
				}
			}
		}
		return strg[0][0];
	}
	public static void main(String[] args) {
		System.out.println(LongestCommonSubsequence.lcs("abcd", "abcd"));
		System.out.println(LongestCommonSubsequence.lcsIter("abcdf", "abcdfgf"));
		

	}

}
