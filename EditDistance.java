
public class EditDistance {

	public static int editDistance(String str1,String str2){
		if(str1.length() == 0){
			return str2.length();
		}
		if(str2.length() == 0){
			return str1.length();
		}
		String ros1 = str1.substring(1);
		String ros2 = str2.substring(1);
		int ans = 0;
		if(str1.charAt(0) == str2.charAt(0)){
			ans = editDistance(ros1,ros2);
		}else{
			int f1 = 1+editDistance(ros1,ros2);
			int f2 = 1+editDistance(ros1,str2);
			int f3 = 1+editDistance(str1,ros2);
			
			ans = Math.min(f1, Math.min(f2, f3));
		}
		return ans;
	}
	
	public static int editDistanceIter(String s1,String s2){
		int strg[][] = new int[s1.length()+1][s2.length()+1];
		strg[s1.length()][s2.length()] =0;
		for(int i = s1.length() ; i >= 0 ; i--){
			for(int j = s2.length() ; j>=0 ; j--){
				if(i == s1.length()){
					strg[i][j] = s2.length() -j;
					continue;
				}
				if(j==s2.length()){
					strg[i][j] = s1.length() -i;
					continue;
				}
				
				if(s1.charAt(i) == s2.charAt(j)){
					strg[i][j] = strg[i+1][j+1];
				}else {
					strg[i][j] = 1+Math.min(strg[i+1][j], Math.min(strg[i+1][j+1], strg[i][j+1]));
				}
			}
		}
		return strg[0][0];
	}
	public static void main(String[] args) {
	System.out.println(EditDistance.editDistance("agbgcjdnjdjcsdjcsjcjs", "acgbcjcnjcsjcs"));
	System.out.println(EditDistance.editDistanceIter("agbgcjdnjdjcsdjcsjcjs", "acgbcjcnjcsjcs"));

	}

}
